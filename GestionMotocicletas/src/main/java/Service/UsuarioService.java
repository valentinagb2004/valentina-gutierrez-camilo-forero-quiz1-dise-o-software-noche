/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DTOs.UsuarioDTO;
import Repository.UsuarioRepository;
import java.sql.SQLException;

/**
 *
 * @author valentina
 */
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository = new UsuarioRepository();  
    
    
    public boolean loguearse(String usuario, String contrasena){
        boolean exito  = usuarioRepository.login(usuario, contrasena);
        return exito;
    }
    
    public boolean registrarUsuario(String username, String password) throws SQLException {
        
        boolean exito = usuarioRepository.registrarUsuario(username, password);
        return exito;
    }
    
}
