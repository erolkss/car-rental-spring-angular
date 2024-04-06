package br.com.ero.carrentelspring.controllers;

import br.com.ero.carrentelspring.dto.SignupRequest;
import br.com.ero.carrentelspring.dto.UserDto;
import br.com.ero.carrentelspring.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        if (authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("Customer already exist with this email", HttpStatus.NOT_ACCEPTABLE);
        UserDto createCustomerDto = authService.createCustomer(signupRequest);
        if (createCustomerDto == null) {
            return new ResponseEntity<>("Customer not created, come again later", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createCustomerDto, HttpStatus.CREATED);
    }
}
