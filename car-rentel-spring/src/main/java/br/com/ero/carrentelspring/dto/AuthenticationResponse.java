package br.com.ero.carrentelspring.dto;

import br.com.ero.carrentelspring.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
