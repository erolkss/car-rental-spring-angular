package br.com.ero.carrentelspring.services.customer;

import br.com.ero.carrentelspring.dto.BookACarDto;
import br.com.ero.carrentelspring.dto.CarDto;
import br.com.ero.carrentelspring.dto.CarDtoListDto;
import br.com.ero.carrentelspring.dto.SearchCarDto;
import br.com.ero.carrentelspring.entities.BookACar;
import br.com.ero.carrentelspring.entities.Car;
import br.com.ero.carrentelspring.entities.User;
import br.com.ero.carrentelspring.enums.BookCarStatus;
import br.com.ero.carrentelspring.repositories.BookACarRepository;
import br.com.ero.carrentelspring.repositories.CarRepository;
import br.com.ero.carrentelspring.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final BookACarRepository bookACarRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
        Optional<Car> optionalCar = carRepository.findById(bookACarDto.getCarId());
        Optional<User> optionalUser = userRepository.findById(bookACarDto.getUserId());
        if (optionalCar.isPresent() && optionalUser.isPresent()) {
            Car existingCar = optionalCar.get();
            BookACar bookACar = new BookACar();
            bookACar.setUser(optionalUser.get());
            bookACar.setCar(existingCar);
            bookACar.setBookCarStatus(BookCarStatus.PENDING);
            bookACar.setFromDate(bookACarDto.getFromDate());
            bookACar.setToDate(bookACarDto.getToDate());
            long diffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
            long days = TimeUnit.DAYS.convert(diffInMilliSeconds, TimeUnit.MILLISECONDS);
            bookACar.setDays(days);
            bookACar.setPrice(existingCar.getPrice() * days);
            bookACarRepository.save(bookACar);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public List<BookACarDto> getBookingsByUserId(Long userId) {
        return bookACarRepository.findAllByUserId(userId).stream().map((BookACar::getBookACarDto)).collect(Collectors.toList());
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car = new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());
        car.setColor(searchCarDto.getColor());
        ExampleMatcher exampleMatcher =
                ExampleMatcher.matchingAll()
                        .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("transmission", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("colo", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<Car> carExample = Example.of(car, exampleMatcher);
        List<Car> carList = carRepository.findAll(carExample);
        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carDtoListDto;
    }

}
