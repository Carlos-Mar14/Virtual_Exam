package com.app.interfaces;

import java.util.List;

import com.app.model.Result;

public interface ResultInterface {

	List<Result> getAllResult();
	
	Result getResultById(int resultId);
	int saveResult(Result result);
	boolean deleteResult(int resultId);
	boolean updateResult(Result result);
}
