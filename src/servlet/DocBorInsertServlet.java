package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import factory.*;
import vo.*;

public class DocBorInsertServlet extends HttpServlet{
    public DocBorInsertServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        String successpath = "StuListsuccess.jsp";
        String failurepath = "StuListfailure.jsp";
        DocBor docbor = new DocBor();
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


        // System.out.println(request.getParameter("sno"));
        Boolean flag = false;
        List<String> info = new ArrayList<String>();
        try {
            flag = DAOFactory.getIDocBorDAOInstance().doCreateDocBor(docbor);

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

        }
        try {
            if (flag) {
                info.add("您插入的书籍状态：" + borrowedbookname);
                request.setAttribute("info", info);
                request.setAttribute("docbor",docbor);
                request.getRequestDispatcher(successpath).forward(request, response);
            } else {
                info.add("插入失败！");
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
