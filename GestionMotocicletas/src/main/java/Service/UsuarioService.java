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
    
    
    public UsuarioDTO loguearse(String usuario, String contrasena) throws SQLException{
        
        UsuarioDTO usuarioDTO = usuarioRepository.login(usuario, contrasena);
        return usuarioDTO;
        
    }
    
}
