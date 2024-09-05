package com.app.modelDAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.configuracion.Conectar;
import com.app.crypto.PasswordUtil;
import com.app.interfaces.UsersInterface;
import com.app.model.Users;

public class UsersDao implements UsersInterface{

	
	// para chequear la contraseña con la base de datos
	
	@Override
	public boolean checkPassword(String username, String password) {
		String sql = "SELECT password FROM Users WHERE name = ?";
        try (Connection con = Conectar.conectarDB();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, username);  // Se establece el nombre de usuario en la consulta
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");  // Se obtiene la contraseña hasheada de la base de datos

                // Verificar la contraseña proporcionada con la hasheada
                return PasswordUtil.checkPassword(password, storedHashedPassword);
            } else {
                // Usuario no encontrado
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores o lanzar una excepción personalizada
            return false;
        }
    }

	// para encriptar la contraseña y que vaya a la base de datos	
	@Override
	public String hashPassword(String password) {
		return PasswordUtil.hashPassword(password);
	}
	
	// para insertar un nuevo usuario en la base de datos
	@Override
	public boolean createUsers(String username, String password, String email) {
		 String sql = "INSERT INTO Users (name, password, email, registration_date) VALUES (?, ?, ?, ?)";
	        try (Connection con = Conectar.conectarDB();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	             
	            String hashedPassword = hashPassword(password);  // Hashear la contraseña

	            // Establecer los valores para la inserción
	            ps.setString(1, username);
	            ps.setString(2, hashedPassword);
	            ps.setString(3, email);
	            ps.setDate(4, new Date(System.currentTimeMillis()));  // Fecha de registro actual

	            // Ejecutar la inserción
	            int rowsInserted = ps.executeUpdate();
	            return rowsInserted > 0;  // Retorna true si se insertó al menos una fila
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de errores o lanzar una excepción personalizada
	            return false;
	        }
	}
	
	//Para agregar una imagen al usuario
	@Override
	public boolean addImageToUser(int userId, InputStream image) {
		String sql = "UPDATE Users SET profile_image = ? WHERE userId = ?";
        try (Connection con = Conectar.conectarDB();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBlob(1, image);
            ps.setInt(2, userId);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Retorna true si se actualizó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores o lanzar una excepción personalizada
            return false;
        }
	}

	// funcion para tener el id del usuario y almacenarlo en la sesion
	@Override
	public int getUserId(String username) {
		String sql = "SELECT userId FROM Users WHERE name = ?";
		try (Connection con = Conectar.conectarDB();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, username);  // Se establece el nombre de usuario en la consulta
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("userId");  // Devuelve el ID del usuario si se encuentra
			} else {
				return -1;  // Devuelve -1 si el usuario no existe
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Puedes lanzar una excepción personalizada o manejar el error de otra manera
			return -1;
		}
	}
	
	@Override
	public boolean deleteUsers(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Users user) {
		
		return false;
	}

	

	
	
}
