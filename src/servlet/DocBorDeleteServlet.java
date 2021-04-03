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

public class DocBorDeleteServlet extends HttpServlet{
    public DocBorDeleteServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String successpath = "StuListsuccess.jsp";
        String failurepath = "StuListfailure.jsp";
        String borrowedbookid = request.getParameter("borrowedbookid");
        borrowedbookid=new String(borrowedbookid.getBytes("ISO8859_1"),"utf-8");


        Boolean flag = false;
        List<String> info = new ArrayList<String>();
        try {
            flag = DAOFactory.getIDocBorDAOInstance().deleteDocBor(borrowedbookid);

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

        }
        try {
            if (flag) {
                info.add("已删除：" + borrowedbookid);
                request.setAttribute("info", info);
                //request.setAttribute("sno", sno);
                request.getRequestDispatcher(successpath).forward(request, response);
            } else {
                info.add("删除失败");
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
