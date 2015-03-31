package com.redhat.xpaas.eap.deployments.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple Servlet-based session-scoped counter
 * 
 * @author maschmid
 *
 */
@SuppressWarnings("serial")
@WebServlet("/EjbCounter")
public class EjbCounterServlet extends HttpServlet {
    
    @Inject
    Counter counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        
        String servletId = (String)req.getServletContext().getAttribute("servletId");

        long count = counter.increment();

        PrintWriter writer = resp.getWriter();
        writer.println(servletId + " " + count);
        writer.close();
    }
}
