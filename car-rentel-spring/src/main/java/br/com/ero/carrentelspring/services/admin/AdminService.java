package br.com.ero.carrentelspring.services.admin;

import br.com.ero.carrentelspring.dto.CarDto;

import java.io.IOException;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;
}
