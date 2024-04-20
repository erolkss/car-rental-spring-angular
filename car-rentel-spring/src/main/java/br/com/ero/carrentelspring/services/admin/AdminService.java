package br.com.ero.carrentelspring.services.admin;

import br.com.ero.carrentelspring.dto.CarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;

    List<CarDto> getAllCars();

    void  deleteCar(Long id);

}
