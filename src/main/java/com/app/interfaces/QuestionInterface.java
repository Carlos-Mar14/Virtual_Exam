package com.app.interfaces;

import java.util.List;

import com.app.model.Question;

public interface QuestionInterface {
	
	// CRUD
    List<Question> getAllQuestions();
    
    Question getQuestionById(Integer questionId);
    int saveQuestion(Question question);
    boolean deleteQuestion(Integer questionId);
    boolean updateQuestion(Question question);
	
}
