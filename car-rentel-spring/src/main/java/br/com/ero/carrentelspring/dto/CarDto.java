package br.com.ero.carrentelspring.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@Data
public class CarDto {
    private Long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private String transmission;
    private Long price;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;
    private MultipartFile img;
    private byte[] returnedImage;
}
