/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTOs.MotocicletaDTO;
import Service.MotocicletaService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author valentina
 */
public class MotocicletaController {
    
    private MotocicletaService motocicletaService = new MotocicletaService();
    
    public ArrayList<MotocicletaDTO> listarTodos() throws SQLException{
       ArrayList<MotocicletaDTO> lista =  motocicletaService.listarTodos();
       return lista;
    }
    
    public  boolean registrarMotocicleta(MotocicletaDTO dto) throws SQLException  {
        boolean exito = motocicletaService.registrarMotocicleta(dto);
        return exito;
    }
    
    public boolean actualizarMotocicleta(MotocicletaDTO dto) throws SQLException {
         boolean exito = motocicletaService.actualizarMotocicleta(dto);
         return exito;
     }
    
    public  boolean eliminarMotocicleta(int id) throws SQLException  {
        boolean exito = motocicletaService.eliminarMotocicleta(id);
        return exito;
    }
}
