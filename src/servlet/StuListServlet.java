package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.*;

import factory.*;
import org.apache.commons.lang3.math.NumberUtils;
import vo.*;

public class StuListServlet extends HttpServlet{
    public StuListServlet(){
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
        String successpath = "stu_list.jsp" ;

        //String SnokeyWord = "0000000000" ;
        String SnokeyWord = request.getParameter("snokw") ;
        SnokeyWord=new String(SnokeyWord.getBytes("ISO8859_1"),"utf-8");

       // int BorrownumberkeyWord = 9999999;
        String str = request.getParameter("borrownumberkw");
        int BorrownumberkeyWord = 9999999;

        if(NumberUtils.isDigits(str))
        {
            BorrownumberkeyWord = Integer.parseInt(request.getParameter("borrownumberkw")) ;
        }
        else {
            BorrownumberkeyWord = 9999999;

        }








        List<Stu> allone = null;
        try {
            allone = DAOFactory.getIStuDAOInstance().findByBorrownumber(BorrownumberkeyWord);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        List<Stu> alltwo = null;
        try {
            alltwo= DAOFactory.getIStuDAOInstance().findBySno(SnokeyWord);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        Iterator<Stu> iterone = allone.iterator() ;
        request.setAttribute("iterone", iterone);
        Iterator<Stu> itertwo = alltwo.iterator() ;
        request.setAttribute("itertwo", itertwo);

        request.getRequestDispatcher(successpath).forward(request,response) ;
    }







}
