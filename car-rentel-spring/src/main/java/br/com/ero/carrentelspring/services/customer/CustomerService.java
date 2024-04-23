package br.com.ero.carrentelspring.services.customer;

import br.com.ero.carrentelspring.dto.BookACarDto;
import br.com.ero.carrentelspring.dto.CarDto;
import br.com.ero.carrentelspring.dto.CarDtoListDto;
import br.com.ero.carrentelspring.dto.SearchCarDto;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    boolean bookACar(BookACarDto bookACarDto);

    CarDto getCarById(Long carId);

    List<BookACarDto> getBookingsByUserId(Long userId);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);
}
