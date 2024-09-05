package com.app.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.configuracion.Conectar;
import com.app.interfaces.ExamInterface;
import com.app.model.Exam;

public class ExamenDAO implements ExamInterface {

	@Override
	public List<Exam> getAllExams() {
		String sql = "SELECT * FROM Examen";
		List<Exam> listaExamenes = new ArrayList<Exam>();

		try {
			Connection con = Conectar.conectarDB();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Exam examen = new Exam();
				examen.setExamId(rs.getInt(1));
				examen.setCreatorId(Integer.valueOf(rs.getString(2)));
				examen.setCreationDate(rs.getDate(3));
				examen.setCategoryId(Integer.valueOf(rs.getString(4)));
				examen.setLevel(rs.getString(5));
//				examen.setImg(getImg(examen.getCreatorId()));
				listaExamenes.add(examen);
			}
		} catch (Exception e) {
			System.out.println("Error ");
		}
		return listaExamenes;
	}

//	private String getImg(String nombreExamen) {
//		if (nombreExamen.contains("Python")) {
//			nombreExamen = "Python.jpg";
//		} else if (nombreExamen.contains("Java")) {
//			
//			nombreExamen = "Java.jpg";
//		}
//		else if (nombreExamen.contains("C++")) {
//			
//			nombreExamen = "C++.jpg";
//		}
//		return nombreExamen;
//	}

	
	@Override
	public int saveExam(Exam examen) {
	
		return 0;
	}

	

	@Override
	public Exam getExamById(int examId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean updateExam(Exam exam) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteExam(int examId) {
		// TODO Auto-generated method stub
		return false;
	}

}
