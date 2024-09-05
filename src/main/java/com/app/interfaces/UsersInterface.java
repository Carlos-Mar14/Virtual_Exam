package com.app.interfaces;

import java.io.InputStream;
import java.util.List;

import com.app.model.Users;

public interface UsersInterface {
	
	List<Users> getAllUsers();
	
	public boolean checkPassword(String username, String password);
    public String hashPassword(String password);
    public boolean insertUsers(String username, String password, String email);
    public boolean addImageToUser(int userId, InputStream image);
    public boolean deleteUsers(int UserId);
    public boolean updateUsers(Users user);
}
