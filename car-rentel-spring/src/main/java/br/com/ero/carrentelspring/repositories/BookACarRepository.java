package br.com.ero.carrentelspring.repositories;

import br.com.ero.carrentelspring.entities.BookACar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookACarRepository extends JpaRepository<BookACar, Long> {
}
