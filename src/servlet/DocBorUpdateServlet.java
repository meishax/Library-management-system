package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.*;
import vo.*;

public class DocBorUpdateServlet extends HttpServlet{
    public DocBorUpdateServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DocBor docbor = new DocBor();
        String successpath = "StuListsuccess.jsp";
        String failurepath = "StuListfailure.jsp";

        String borrowedbookid = request.getParameter("borrowedbookid");
        String borrowedbookname = request.getParameter("borrowedbookname");
        String borrowstudentsno = request.getParameter("borrowstudentsno");
        String borrowstudentname = request.getParameter("borrowstudentname");

        borrowedbookid=new String(borrowedbookid.getBytes("ISO8859_1"),"utf-8");
        borrowedbookname=new String(borrowedbookname.getBytes("ISO8859_1"),"utf-8");
        borrowstudentsno=new String(borrowstudentsno.getBytes("ISO8859_1"),"utf-8");
        borrowstudentname=new String(borrowstudentname.getBytes("ISO8859_1"),"utf-8");

        docbor.setBorrowedbookid(borrowedbookid);
        docbor.setBorrowedbookname(borrowedbookname);
        docbor.setBorrowstudentsno(borrowstudentsno);
        docbor.setBorrowstudentname(borrowstudentname);


        Boolean flag = false;
        List<String> info = new ArrayList<String>();
        try {
            flag = DAOFactory.getIDocBorDAOInstance().updateDocBor(docbor);

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

        }
        try {
            if (flag) {
                info.add("您修改的书籍状态：" + borrowedbookname);
                request.setAttribute("info", info);
                request.setAttribute("docbor", docbor);
                request.getRequestDispatcher(successpath).forward(request, response);
            } else {
                info.add("修改失败");
                request.setAttribute("info", info);
                request.getRequestDispatcher(failurepath).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void  doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        this.doPost(req,resp);
    }
}
