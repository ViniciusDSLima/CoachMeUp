package com.example.customerservice.service;

import com.example.customerservice.DTO.UsuarioDTO;
import com.example.customerservice.domain.models.Usuario;
import com.example.customerservice.mapper.UsuarioMapper;
import com.example.customerservice.repository.UsuarioRepository;
import com.example.customerservice.request.usuario.UsuarioRequestRegister;
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
