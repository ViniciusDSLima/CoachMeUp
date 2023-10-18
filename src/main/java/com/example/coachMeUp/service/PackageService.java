package com.example.coachMeUp.service;

import com.example.coachMeUp.DTO.PackageDTO;
import com.example.coachMeUp.domain.entities.Package;
import com.example.coachMeUp.mapper.PackageMapper;
import com.example.coachMeUp.repository.PackageRepository;
import com.example.coachMeUp.request.packages.PackageRegisterRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PackageService {

    private PackageRepository packageRepository;

    public PackageDTO packageRegister(@Valid PackageRegisterRequest request) {

        Package aPackage = packageRepository.save(PackageMapper.INSTANCE.toPackage(request));

        return PackageMapper.INSTANCE.toPackageDTO(aPackage);
    }
}
