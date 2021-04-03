package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import factory.*;
import vo.*;

public class LoginCreateServlet extends HttpServlet{
    public LoginCreateServlet(){
        super();
    }
    public void destory(){
        super.destroy();
    }

    public Map<String,String> errors=null;

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        String successpath = "signup_success.jsp";
        String failurepath = "signup.jsp";
        Login login = new Login();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordagain = request.getParameter("passwordagain");
        String identityx = request.getParameter("identityx");



        username=new String(username.getBytes("ISO8859_1"),"utf-8");
        email=new String(email.getBytes("ISO8859_1"),"utf-8");
        password=new String(password.getBytes("ISO8859_1"),"utf-8");
        passwordagain=new String(passwordagain.getBytes("ISO8859_1"),"utf-8");
        identityx=new String(identityx.getBytes("ISO8859_1"),"utf-8");



        boolean flagc = true ;
       if(!username.matches("\\w{6,16}")){
            flagc = false ;
            username = "" ;	// 清空原本的name内容
            errors.put("errname","用户名是6~16位的字母或数字。") ;
        }
        if(!email.matches("\\w+@\\w+\\.\\w+\\.?\\w*")){
            flagc = false ;
            email = "" ;	// 清空原本的name内容
            errors.put("erremail","输入的email地址不合法。") ;
        }
        if(!password.matches("[\\d\\D]{4,8}")){
            flagc = false ;
            password = "" ;	// 清空原本的name内容
            errors.put("errpassword","密码为4~8位") ;
        }
        if(!passwordagain.matches(password)){
            flagc = false ;
            passwordagain = "" ;	// 清空原本的name内容
            errors.put("errpasswordagain","两次密码不一致") ;
        }



        if (flagc)
        {
            login.setUsername(username);
            login.setPassword(password);
            login.setIdentityx(identityx);
            Boolean flag = false;
            List<String> info = new ArrayList<String>();
            try {
                flag = DAOFactory.getILoginDAOInstance().doCreateLogin(login);

            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {

            }


            try {
                if (flag) {
                    info.add("注册成功，用户：" + username);
                    request.setAttribute("info", info);
                   // request.setAttribute("stu", stu);
                    request.getRequestDispatcher(successpath).forward(request, response);
                } else {
                    info.add("注册失败！");
                    request.setAttribute("info", info);
                    request.getRequestDispatcher(failurepath).forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }



    public void  doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        this.doPost(req,resp);
    }


}
