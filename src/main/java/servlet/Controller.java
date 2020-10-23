package com.servlet;

import tools.DbTool;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String _username = request.getParameter("vcbrukernavn");
            String _password = request.getParameter("vcpassord");
            String action = request.getParameter("action");
            Connection db = null;
            PreparedStatement pwm = null;

            try {
         //   String in = req.getParameter("in");
           // if (action.contains("login"))


                if (_username != null && action.contains("Login")) {
                    //    try {
                    db = DbTool.getINSTANCE().dbLoggIn(out);
                    String Query = "Select * from Roprosjekt.Brukerinfo where Brukernavn=? and Passord=?";
                    //  PreparedStatement psm = conn.prepareStatement(Query);
                    pwm.setString(1, _username);
                    pwm.setString(2, _password);
                    ResultSet rs = pwm.executeQuery();
                    if (rs.next()) {
                        response.sendRedirect("AdminSide.jsp");
                    } else
                        response.sendRedirect("Login.jsp");
                } else
                    System.out.println("Eriks Error");
                } catch (Exception ex) {
                    out.println("Exception :" + ex.getMessage());
                }
            }

        }

    }


