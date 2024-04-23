package br.com.ero.carrentelspring.services.admin;

import br.com.ero.carrentelspring.dto.BookACarDto;
import br.com.ero.carrentelspring.dto.CarDto;
import br.com.ero.carrentelspring.dto.CarDtoListDto;
import br.com.ero.carrentelspring.dto.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;

    List<CarDto> getAllCars();

    void  deleteCar(Long id);

    CarDto getCarById(Long id);

    boolean updateCar (Long id, CarDto carDto) throws IOException;

    List<BookACarDto> getBookings();

    boolean changeBookingStatus(Long bookingId, String status);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
