package com.example.coachMeUp.mapper;

import com.example.coachMeUp.DTO.UsuarioDTO;
import com.example.coachMeUp.domain.entities.Usuario;
import com.example.coachMeUp.request.usuario.UsuarioRequestRegister;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    Usuario toUsuario(UsuarioRequestRegister request);
    UsuarioDTO toUsuarioDTO(Usuario usuario);

}
