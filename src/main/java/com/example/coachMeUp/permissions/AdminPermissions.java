package com.example.coachMeUp.permissions;

public interface AdminPermissions {

    final String[] PERMISSOES_ADMINISTRACAO = {
            "/api/v1/courses/register",
            "/api/v1/courses/delete/{id}",
            "/api/v1/courses/update/{id}",
            "/api/v1/courses/update/{id}",
            "/api/v1/customer/findBy/{id}",
            "/api/v1/customer/delete/{id}"
    };
}
