package com.app.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.app.model.Exam;
import com.app.modelDAO.ExamenDAO;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ExamenDAO eDao;

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch (accion) {
		case "Principal":
			List<Exam> listExamens = eDao.getAllExams();
			request.setAttribute("Examenes", listExamens);
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

}
