package com.app.controlador;

import java.io.IOException;

import com.app.modelDAO.UsersDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class SignIn
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UsersDao usersDao = new UsersDao();
		if(usersDao.createUsers(username, password, email)) {
			HttpSession session = request.getSession();
			int userId = usersDao.getUserId(username);
			session.setAttribute("userId", userId);
			response.sendRedirect("home"); 
		}else {
			System.out.println("Error al crear usuario");
		}
	}

}
