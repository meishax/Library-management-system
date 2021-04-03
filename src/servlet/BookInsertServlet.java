package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import factory.*;
import vo.*;

public class BookInsertServlet extends HttpServlet{
    public BookInsertServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        String successpath = "StuListsuccess.jsp";
        String failurepath = "StuListfailure.jsp";
        Book book = new Book();
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
        // System.out.println(request.getParameter("sno"));
        Boolean flag = false;
        List<String> info = new ArrayList<String>();
        try {
            flag = DAOFactory.getIBookDAOInstance().doCreateBook(book);

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

        }
        try {
            if (flag) {
                info.add("您插入的书名：" + bookname);
                request.setAttribute("info", info);
                request.setAttribute("book", book);
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
