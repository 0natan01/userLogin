package com.example.loginPessoal.business;

import com.example.loginPessoal.infrastructure.exceptions.ConflictExeptions;
import com.example.loginPessoal.infrastructure.model.Usuario;
import com.example.loginPessoal.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        try {
            emailExiste(usuario.getEmail());
            return usuarioRepository.save(usuario);
        } catch (ConflictExeptions e){
            throw new ConflictExeptions("Email ja cadastrado" + e.getCause());
        }
    }

    public void emailExiste(String email){
        try{
            boolean existe = verificaEmailExistente(email);
            if(existe){
                throw new ConflictExeptions("Email ja cadastrado" + email);
            }
        } catch (ConflictExeptions e){
            throw new ConflictExeptions("Email ja cadastrado" + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public void deletarUsuario(Long id){
         usuarioRepository.deleteById(id);
    }
}
