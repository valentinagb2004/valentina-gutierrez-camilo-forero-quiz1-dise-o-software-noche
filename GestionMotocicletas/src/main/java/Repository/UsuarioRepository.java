/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTOs.UsuarioDTO;
import gestionmotocicletas.DataBaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author valentina
 */
public class UsuarioRepository {
    
    public boolean login(String cedula, String contrasena){
        String query = "SELECT * FROM usuario WHERE cedula = ?";
        try (
             Connection conn = DataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPasswordHash = rs.getString("contrasena");
                
                return checkPassword(contrasena, storedPasswordHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public  boolean registrarUsuario(String username, String password) throws SQLException  {
        String query = "INSERT INTO usuario (cedula, contrasena) VALUES (?, ?)";
        try (Connection conn = DataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            String hashedPassword = hashPassword(password);

            ps.setString(1, username);
            ps.setString(2, hashedPassword);

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
     private static boolean checkPassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
    
}
