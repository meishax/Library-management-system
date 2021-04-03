package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.*;
import vo.*;

public class DocBorListServlet extends HttpServlet{
    public DocBorListServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String successpath = "docbor_list.jsp" ;

        //String SnokeyWord = "0000000000" ;
        String BorrowedbookidkeyWord = request.getParameter("borrowedbookidkw") ;
        BorrowedbookidkeyWord=new String(BorrowedbookidkeyWord.getBytes("ISO8859_1"),"utf-8");

        // int BorrownumberkeyWord = 9999999;
        String BorrowstudentsnokeyWord = request.getParameter("borrowstudentsnokw") ;
        BorrowstudentsnokeyWord=new String(BorrowstudentsnokeyWord.getBytes("ISO8859_1"),"utf-8");

        List<DocBor> allone = null;
        try {
            allone = DAOFactory.getIDocBorDAOInstance().findByBorrowedbookid(BorrowedbookidkeyWord);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        List<DocBor> alltwo = null;
        try {
            alltwo= DAOFactory.getIDocBorDAOInstance().findByBorrowstudentsno(BorrowstudentsnokeyWord);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        Iterator<DocBor> iterone = allone.iterator() ;
        request.setAttribute("iterone", iterone);
        Iterator<DocBor> itertwo = alltwo.iterator() ;
        request.setAttribute("itertwo", itertwo);

        request.getRequestDispatcher(successpath).forward(request,response) ;
    }





}
