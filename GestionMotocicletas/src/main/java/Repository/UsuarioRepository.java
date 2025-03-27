/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTOs.UsuarioDTO;
import gestionmotocicletas.DataBaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author valentina
 */
public class UsuarioRepository {
    
    public UsuarioDTO login(String cedula, String contrasena) throws SQLException {
        String query = "SELECT * FROM usuario WHERE cedula = '" + cedula + "' and contrasena = '"+contrasena+"'";
        try (
            Connection connection = DataBaseConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                
                UsuarioDTO dto = new UsuarioDTO(
                    resultSet.getString("cedula"),     
                    resultSet.getString("contrasena")
                );
                return dto;
            } else {
                return null;
            }
        }
    }
    
}
