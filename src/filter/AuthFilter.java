package filter;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String uri = request.getRequestURI();

        //如果访问的资源是以css或者js结尾的，那么就不需要判断是否登录
        if (uri.endsWith(".css") || uri.endsWith(".js")) {
            chain.doFilter(request, response);
            return;
        }

        if (uri.endsWith("login.jsp")||uri.endsWith("login_check.jsp")||uri.endsWith("login_failure.jsp")||uri.endsWith("signup.jsp")||uri.endsWith("check.jsp")||uri.endsWith("signup_success.jsp")||uri.endsWith("signup")) {
            chain.doFilter(request, response);
            return;
        }

        String userName = (String) request.getSession().getAttribute("userName");
        if (null == userName) {
            response.sendRedirect("login.jsp");
            return;
        }

        String identityx = (String) request.getSession().getAttribute("identityx");
        identityx=new String(identityx.getBytes("ISO8859_1"),"utf-8");
        if(identityx.equals("user"))
        {
            if (uri.endsWith("login.jsp")||uri.endsWith("login_check.jsp")||uri.endsWith("login_failure.jsp")
                    ||uri.endsWith("signup.jsp")||uri.endsWith("check.jsp")||uri.endsWith("signup_success.jsp")||uri.endsWith("signup")
                    ||uri.endsWith("welcome_user.jsp")
                    ||uri.endsWith("stu_delete")||uri.endsWith("stu_delete.jsp")
                    ||uri.endsWith("stu_insert")||uri.endsWith("stu_insert.jsp")
                    ||uri.endsWith("stu_list")||uri.endsWith("stu_list.jsp")
                    ||uri.endsWith("stu_update")||uri.endsWith("stu_update.jsp")
                    ||uri.endsWith("book_list")||uri.endsWith("book_list.jsp")
                    ||uri.endsWith("docbor_list")||uri.endsWith("docbor_list.jsp")
                    ||uri.endsWith("borrow_book")
                    ||uri.endsWith("noauth.jsp")
                    ||uri.endsWith("logout.jsp")
                    ||uri.endsWith("forget-password.jsp")) {
                chain.doFilter(request, response);
                return;
            }
            else {
                response.sendRedirect("noauth.jsp");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
