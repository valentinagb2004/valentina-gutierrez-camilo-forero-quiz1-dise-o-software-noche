/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DTOs.MotocicletaDTO;
import Repository.MotocicletaRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author valentina
 */
public class MotocicletaService {
    
    private MotocicletaRepository motocicletaRepository = new MotocicletaRepository();
    
    public ArrayList<MotocicletaDTO> listarTodos() throws SQLException{
        ArrayList<MotocicletaDTO> lista =  motocicletaRepository.listarTodos();
        return lista;
    }
    
    public  boolean registrarMotocicleta(MotocicletaDTO dto) throws SQLException  {
        boolean exito = motocicletaRepository.registrarMotocicleta(dto);
        return exito;
    }
    
     public boolean actualizarMotocicleta(MotocicletaDTO dto) throws SQLException {
         boolean exito = motocicletaRepository.actualizarMotocicleta(dto);
         return exito;
     }
    
    public  boolean eliminarMotocicleta(int id) throws SQLException  {
        boolean exito = motocicletaRepository.eliminarMotocicleta(id);
        return exito;
    }
    
}
