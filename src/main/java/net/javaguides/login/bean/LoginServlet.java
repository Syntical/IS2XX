package net.javaguides.login.bean;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.login.bean.LoginBean;
import net.javaguides.login.bean.LoginDao;



@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String brukernavn = request.getParameter("brukernavn");
        String passord = request.getParameter("passord");
        LoginBean loginBean = new LoginBean();
        loginBean.setBrukernavn(brukernavn);
        loginBean.setPassord(passord);

        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                session.setAttribute("brukernavn",brukernavn);
                response.sendRedirect("Adminside.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("bruker", brukernavn);
                response.sendRedirect("Login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}