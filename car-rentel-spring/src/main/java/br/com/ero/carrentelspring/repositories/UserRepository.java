package br.com.ero.carrentelspring.repositories;

import br.com.ero.carrentelspring.entities.User;
import br.com.ero.carrentelspring.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);

    User findByUserRole(UserRole userRole);
}
