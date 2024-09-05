package com.app.interfaces;

import java.io.InputStream;

import com.app.model.Users;

public interface UsersInterface {
	
	public boolean checkPassword(String username, String password);
	public String hashPassword(String password);
	public boolean createUsers(String username, String password, String email);
	public boolean addImageToUser(int userId, InputStream image);
	public boolean deleteUsers(int userId);
	public boolean updateUser(Users user);
	public int getUserId(String username);
}
