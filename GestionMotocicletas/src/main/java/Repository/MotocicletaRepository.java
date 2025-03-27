/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DTOs.MotocicletaDTO;
import gestionmotocicletas.DataBaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author valentina
 */
public class MotocicletaRepository {
    
    public ArrayList<MotocicletaDTO> listarTodos() throws SQLException {
        ArrayList<MotocicletaDTO> lista = new ArrayList<MotocicletaDTO>();
        String query = "SELECT * FROM motocicleta";
        try (
            Connection connection = DataBaseConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
             while (resultSet.next()) {
                
                MotocicletaDTO dto = new MotocicletaDTO(
                    resultSet.getInt("id_motocicleta"),     
                    resultSet.getString("marca"),
                    resultSet.getInt("cilindraje"),
                    resultSet.getDouble("precio"),
                    resultSet.getString("color")
                );
                lista.add(dto);
            }
        }
        return lista;
    }
    
    public  boolean registrarMotocicleta(MotocicletaDTO dto) throws SQLException  {
        String query = "INSERT INTO motocicleta (marca, cilindraje, precio, color) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {


            ps.setString(1, dto.getMarca());
            ps.setInt(2, dto.getCilindraje());
            ps.setDouble(3, dto.getPrecio());
            ps.setString(4, dto.getColor());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizarMotocicleta(MotocicletaDTO dto) throws SQLException {
        String query = "UPDATE motocicleta SET marca = ?, cilindraje = ?, precio = ?, color = ? WHERE id_motocicleta = ?";

        try (Connection conn = DataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, dto.getMarca());
            ps.setInt(2, dto.getCilindraje());
            ps.setDouble(3, dto.getPrecio());
            ps.setString(4, dto.getColor());
            ps.setInt(5, dto.getId()); 

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public  boolean eliminarMotocicleta(int id) throws SQLException  {
        String query = "delete from motocicleta where id_motocicleta = ?";
        try (Connection conn = DataBaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
