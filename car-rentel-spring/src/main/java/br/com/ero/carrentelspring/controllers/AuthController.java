package br.com.ero.carrentelspring.controllers;

import br.com.ero.carrentelspring.dto.AuthenticationRequest;
import br.com.ero.carrentelspring.dto.AuthenticationResponse;
import br.com.ero.carrentelspring.dto.SignupRequest;
import br.com.ero.carrentelspring.dto.UserDto;
import br.com.ero.carrentelspring.entities.User;
import br.com.ero.carrentelspring.repositories.UserRepository;
import br.com.ero.carrentelspring.services.auth.AuthService;
import br.com.ero.carrentelspring.services.jwt.UserService;
import br.com.ero.carrentelspring.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

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

    @PostMapping("/login")
    public AuthenticationResponse creationAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException, DisabledException, UsernameNotFoundException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Incorrect e-mail or password!");
        }

        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if (optionalUser.isPresent()) {
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserId(optionalUser.get().getId());
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
        }
        return authenticationResponse;
    }
}
