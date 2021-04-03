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

import dao.*;
import factory.*;
import vo.*;






//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃

//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃

//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃
//这个页面的内容已废弃//这个页面的内容已废弃
//这个页面的内容已废弃



























public class StuShowServlet extends HttpServlet{
    public StuShowServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=UTF-8");
        List<Stu> stuall = null;

        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>学号</td><td>姓名</td><td>班级</td><td>专业</td><td>借阅数</td><td>删除</td></tr>\r\n");
        String trFormat = "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td><td><a href='stu_delete?学号=%s'>delete</a></td></tr>\r\n";

        try {
            stuall = DAOFactory.getIStuDAOInstance().findAllStu();
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

       // Iterator<Stu> iterstuall = stuall.iterator() ;

        for (int i=0; i<stuall.size(); i++) {
            String tr = String.format(trFormat, stuall.get(i));
            sb.append(tr);
            sb.append(tr);
        }

        sb.append("</table>");

        response.getWriter().write(sb.toString());

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);

    }




    public void init() throws ServletException {
        // Put your code here
    }

}
