package com.app.controlador;

import java.io.IOException;
import java.io.InputStream;

import com.app.modelDAO.UsersDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

// controla la edicion del username, mail, password e imagen

/**
 * Servlet implementation class EditUser
 */
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int userId = (int) session.getAttribute("userId");
		
		String newUsername = request.getParameter("username");
        String newEmail = request.getParameter("email");
        String newPassword = request.getParameter("password");
		
        // si modificar imagen
        
        UsersDao us = new UsersDao();
        
        Part profileImagePart = request.getPart("profileImage"); // Imagen subida
        InputStream profileImageStream = profileImagePart.getInputStream();

        us.addImageToUser(userId, profileImageStream);
        
	}

}
