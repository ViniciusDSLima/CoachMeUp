package com.example.coachMeUp.service;

import com.example.coachMeUp.DTO.UsuarioDTO;
import com.example.coachMeUp.domain.entities.Usuario;
import com.example.coachMeUp.mapper.UsuarioMapper;
import com.example.coachMeUp.repository.UsuarioRepository;
import com.example.coachMeUp.request.usuario.UsuarioRequestRegister;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioDTO singup(@Valid UsuarioRequestRegister request){

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        Usuario usuario = usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(request));

        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuario);
    }

}
