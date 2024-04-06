package br.com.ero.carrentelspring.dto;

import br.com.ero.carrentelspring.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private UserRole userRole;
}
