package com.app.controlador;

import java.io.IOException;

import com.app.modelDAO.UsersDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
public class Login extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsersDao usersDao = new UsersDao();
		if(usersDao.checkPassword(username, password)) {
			HttpSession session = request.getSession();
			int userId = usersDao.getUserId(username);
			session.setAttribute("userId", userId);
			response.sendRedirect("profile.jsp");
		}else {
			 response.sendRedirect("index.jsp?loginError=true");
		}
	}

}
