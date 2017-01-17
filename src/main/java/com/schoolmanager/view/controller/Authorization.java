package com.schoolmanager.view.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Dawid on 17.01.2017.
 */

@WebFilter(filterName = "Authorization", urlPatterns = { "*.xhtml" })
public class Authorization implements Filter {

    public Authorization() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if (reqURI.indexOf("/loginPage.xhtml") >= 0
                    || (ses != null && ses.getAttribute("USERNAME") != null)
                    || reqURI.contains("javax.faces.resource")
                    || reqURI.indexOf("/registration.xhtml") >= 0)
                chain.doFilter(request, response);
            else
                resp.sendRedirect(reqt.getContextPath() + "/loginPage.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
