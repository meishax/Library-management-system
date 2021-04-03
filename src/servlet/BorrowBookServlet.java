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

public class BorrowBookServlet extends HttpServlet{
    public BorrowBookServlet(){
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



        String sno = (String) request.getSession().getAttribute("userName");
        sno=new String(sno.getBytes("ISO8859_1"),"utf-8");




        Boolean flagsql = false;
        Boolean flagno = true;
        Boolean flaguser = true;



        List<String> info = new ArrayList<String>();

        List<Stu> all = null;
        try {
            all= DAOFactory.getIStuDAOInstance().findBySno(sno);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        String sname = "";
        String sclass = "";
        String smajor = "";
        int borrownumber = 0;

        Iterator<Stu> iter = all.iterator() ;
        while(iter.hasNext()){
            Stu stuit = iter.next();
            sno = stuit.getSno();
            sname = stuit.getSname();
            sclass = stuit.getSclass();
            smajor = stuit.getSmajor();
            borrownumber = stuit.getBorrownumber();
        }

        sno=new String(sno.getBytes("ISO8859_1"),"utf-8");
        sname=new String(sname.getBytes("ISO8859_1"),"utf-8");
        sclass=new String(sclass.getBytes("ISO8859_1"),"utf-8");
        smajor=new String(smajor.getBytes("ISO8859_1"),"utf-8");



        if (borrownumber<10)
        {
            borrownumber++;
            flaguser = true;
        }
        else {
            info.add("您目前最多借阅10本书");
            flaguser = false;

        }


        if (borrowablenumber>0)
        {
            borrowablenumber--;
            flagno = true;
        }
        else {
            info.add("该书余量不足");
            flagno = false;
        }


        book.setISBN(ISBN);
        book.setBookname(bookname);
        book.setPress(press);
        book.setAuthor(author);
        book.setBorrowablenumber(borrowablenumber);

        Stu stux = new Stu();

        stux.setSno(sno);
        stux.setSname(sname);
        stux.setSclass(sclass);
        stux.setSmajor(smajor);
        stux.setBorrownumber(borrownumber);


        DocBor docbor = new DocBor();
        String borrowedbookid =ISBN + "_" + sno;
        String borrowedbookname = bookname;
        String borrowstudentsno = sno;
        String borrowstudentname = sname;
        docbor.setBorrowedbookid(borrowedbookid);
        docbor.setBorrowedbookname(borrowedbookname);
        docbor.setBorrowstudentsno(borrowstudentsno);
        docbor.setBorrowstudentname(borrowstudentname);


        if (flagno&&flaguser) {
            try {
                flagsql = DAOFactory.getIBookDAOInstance().updateBook(book);
                flagsql = DAOFactory.getIStuDAOInstance().updateStu(stux);
                flagsql = DAOFactory.getIDocBorDAOInstance().doCreateDocBor(docbor);
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {

            }
        }



        try {
            if (flagsql&&flagno&&flaguser) {
                info.add("借阅成功");
                request.setAttribute("info", info);
                //request.setAttribute("book", book);
                request.getRequestDispatcher(successpath).forward(request, response);
            } else {
                info.add("借阅失败");
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
