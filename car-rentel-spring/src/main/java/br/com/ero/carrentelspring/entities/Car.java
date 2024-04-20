package br.com.ero.carrentelspring.entities;

import br.com.ero.carrentelspring.dto.CarDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private Long price;
    private String transmission;
    private String description;
    private Date year;
    @Column(columnDefinition = "longblob")
    private byte[] img;

    public CarDto getCarDto(){
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setBrand(brand);
        carDto.setColor(color);
        carDto.setPrice(price);
        carDto.setDescription(description);
        carDto.setType(type);
        carDto.setTransmission(transmission);
        carDto.setYear(year);
        carDto.setReturnedImage(img);

        return carDto;
    }
}
