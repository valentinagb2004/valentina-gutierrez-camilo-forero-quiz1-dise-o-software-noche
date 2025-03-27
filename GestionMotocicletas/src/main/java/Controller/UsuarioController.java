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
    
    private UsuarioService usuarioService = new UsuarioService();
    
    public boolean isLogueado(String usuario, String contrasena){
        boolean exito = usuarioService.loguearse(usuario, contrasena);
        return exito;
    }
    
    public boolean registrarUsuario(String username, String password) throws SQLException {
        boolean exito = usuarioService.registrarUsuario(username, password);
        return exito;
    }
    
}
