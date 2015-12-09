package com.zhou.filter;

import com.zhou.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by icepoint1999 on 12/7/15.
 */
@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpSession session = servletRequest.getSession();
        String path = servletRequest.getRequestURI();


        if(path.indexOf("/user/login.jsp") > -1 ||path.indexOf("/user/signup.jsp")>-1 ||path.indexOf("login.do")>-1||path.indexOf("/signup.do")>-1
    )
        {
            if ((User)session.getAttribute("user")!=null) {


                servletResponse.sendRedirect(path);

        }else{
                chain.doFilter(servletRequest, servletResponse);
                return;
            }

        }



        if ((User)session.getAttribute("user")==null) {
            // 跳转到登陆页面

            servletResponse.sendRedirect("/user/login.jsp");
        } else {
            // 已经登陆,继续此次请求

            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
