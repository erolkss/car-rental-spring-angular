package br.com.ero.carrentelspring.services.customer;

import br.com.ero.carrentelspring.dto.CarDto;
import br.com.ero.carrentelspring.entities.Car;
import br.com.ero.carrentelspring.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }
}
