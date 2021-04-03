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

public class BookUpdateServlet extends HttpServlet{

    public BookUpdateServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        String successpath = "StuListsuccess.jsp";
        String failurepath = "StuListfailure.jsp";
        String ISBN = request.getParameter("ISBN");
        String bookname = request.getParameter("bookname");
        String press = request.getParameter("press");
        String author = request.getParameter("author");
        int borrowablenumber = Integer.parseInt(request.getParameter("borrowablenumber"));
        ISBN=new String(ISBN.getBytes("ISO8859_1"),"utf-8");
        bookname=new String(bookname.getBytes("ISO8859_1"),"utf-8");
        press=new String(press.getBytes("ISO8859_1"),"utf-8");
        author=new String(author.getBytes("ISO8859_1"),"utf-8");
        book.setISBN(ISBN);
        book.setBookname(bookname);
        book.setPress(press);
        book.setAuthor(author);
        book.setBorrowablenumber(borrowablenumber);


        Boolean flag = false;
        List<String> info = new ArrayList<String>();
        try {
            flag = DAOFactory.getIBookDAOInstance().updateBook(book);
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

        }
        try {
            if (flag) {
                info.add("您修改的书名：" + bookname);
                request.setAttribute("info", info);
                request.setAttribute("book", book);
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
