package br.com.ero.carrentelspring.services.auth;

import br.com.ero.carrentelspring.dto.SignupRequest;
import br.com.ero.carrentelspring.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);
}
