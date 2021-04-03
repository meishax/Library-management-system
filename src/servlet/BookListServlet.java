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

public class BookListServlet extends HttpServlet{

    public  BookListServlet(){
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
        String successpath = "book_list.jsp" ;

        //String SnokeyWord = "0000000000" ;
        String ISBNkeyWord = request.getParameter("ISBNkw") ;
        ISBNkeyWord=new String(ISBNkeyWord.getBytes("ISO8859_1"),"utf-8");

        // int BorrownumberkeyWord = 9999999;
        String BooknamekeyWord = request.getParameter("booknamekw") ;
        BooknamekeyWord=new String(BooknamekeyWord.getBytes("ISO8859_1"),"utf-8");

        List<Book> allone = null;
        try {
            allone = DAOFactory.getIBookDAOInstance().findByISBN(ISBNkeyWord);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        List<Book> alltwo = null;
        try {
            alltwo= DAOFactory.getIBookDAOInstance().findByBookname(BooknamekeyWord);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        Iterator<Book> iterone = allone.iterator() ;
        request.setAttribute("iterone", iterone);
        Iterator<Book> itertwo = alltwo.iterator() ;
        request.setAttribute("itertwo", itertwo);

        request.getRequestDispatcher(successpath).forward(request,response) ;
    }



}
