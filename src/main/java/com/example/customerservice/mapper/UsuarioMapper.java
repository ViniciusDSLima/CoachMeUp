package com.example.customerservice.mapper;

import com.example.customerservice.DTO.UsuarioDTO;
import com.example.customerservice.domain.entities.Usuario;
import com.example.customerservice.request.usuario.UsuarioRequestRegister;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    Usuario toUsuario(UsuarioRequestRegister request);
    UsuarioDTO toUsuarioDTO(Usuario usuario);

}
