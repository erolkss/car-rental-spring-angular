package br.com.ero.carrentelspring.repositories;

import br.com.ero.carrentelspring.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
