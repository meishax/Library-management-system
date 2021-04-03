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


public class StuUpdateServlet extends HttpServlet{
    public StuUpdateServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stu stu = new Stu();
        String successpath = "StuListsuccess.jsp";
        String failurepath = "StuListfailure.jsp";
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        String sclass = request.getParameter("sclass");
        String smajor = request.getParameter("smajor");
        int borrownumber = Integer.parseInt(request.getParameter("borrownumber"));
        sno=new String(sno.getBytes("ISO8859_1"),"utf-8");
        sname=new String(sname.getBytes("ISO8859_1"),"utf-8");
        sclass=new String(sclass.getBytes("ISO8859_1"),"utf-8");
        smajor=new String(smajor.getBytes("ISO8859_1"),"utf-8");
        stu.setSno(sno);
        stu.setSname(sname);
        stu.setSclass(sclass);
        stu.setSmajor(smajor);
        stu.setBorrownumber(borrownumber);

        Boolean flag = false;
        List<String> info = new ArrayList<String>();
        Boolean flaguser = true;
        String identityx = (String) request.getSession().getAttribute("identityx");
        identityx=new String(identityx.getBytes("ISO8859_1"),"utf-8");
        String userName = (String) request.getSession().getAttribute("userName");
        userName=new String(userName.getBytes("ISO8859_1"),"utf-8");
        if(identityx.equals("user")) {
            if (userName.equals(sno)) {
                flaguser = true;
            }
            else {
                flaguser = false;
                info.add("您只能创建、更新、删除自己的信息");
            }
        }



        try {
            if (flaguser) {
                flag = DAOFactory.getIStuDAOInstance().updateStu(stu);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

        }
        try {
            if (flag) {
                info.add("您修改的学生：" + sname);
                request.setAttribute("info", info);
                request.setAttribute("stu", stu);
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
