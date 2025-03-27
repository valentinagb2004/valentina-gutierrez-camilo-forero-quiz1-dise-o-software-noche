/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gestionmotocicletas;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author valentina
 */
public class GestionMotocicletas {
    
    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL =  dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            if (connection != null) {
             System.out.println("Conexión exitosa!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
