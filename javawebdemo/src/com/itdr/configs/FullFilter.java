package com.itdr.configs;

import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/backed/*")
public class FullFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 管理员权限校验
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        String[] split = requestURI.split("/");

        if ("login".equals(split[split.length - 1])){
            // 登录页面直接放行
            chain.doFilter(req,resp);
        }else {
            // 其他请求都需要验证管理员权限以及是否登录
            HttpSession httpSession = ((HttpServletRequest)req).getSession();
            Users us = (Users) httpSession.getAttribute("us");


            if (us == null || us.getType() != 1){
                // 转发到禁止界面
                req.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(req,resp);
            }else {
                // 放行
                chain.doFilter(req,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
