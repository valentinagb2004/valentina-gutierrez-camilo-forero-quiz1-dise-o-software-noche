/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTOs.UsuarioDTO;
import Service.UsuarioService;
import java.sql.SQLException;

/**
 *
 * @author valentina
 */
public class UsuarioController {
    
    UsuarioService usuarioService = new UsuarioService();
    
    public boolean isLogueado(String usuario, String contrasena) throws SQLException{
        UsuarioDTO dto =usuarioService.loguearse(usuario, contrasena);
        if(dto == null){
            return false;
        }
        
        return true;
    }
    
}
