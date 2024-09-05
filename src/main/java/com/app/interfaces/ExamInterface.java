package com.app.interfaces;

import java.util.List;

import com.app.model.Exam;

public interface ExamInterface {
	
	// CRUD
    List<Exam> getAllExams();
    
    Exam getExamById(int examId);
    int saveExam(Exam exam);
    boolean deleteExam(int examId);
    boolean updateExam(Exam exam);
}
