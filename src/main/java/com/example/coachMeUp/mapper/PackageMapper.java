package com.example.coachMeUp.mapper;

import com.example.coachMeUp.DTO.PackageDTO;
import com.example.coachMeUp.domain.entities.Package;
import com.example.coachMeUp.request.packages.PackageRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PackageMapper {

    PackageMapper INSTANCE = Mappers.getMapper(PackageMapper.class);

    Package toPackage(PackageRegisterRequest request);

    PackageDTO toPackageDTO(Package aPackage);
}
