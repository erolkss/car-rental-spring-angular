package br.com.ero.carrentelspring.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CarDto {
    private Long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private String transmission;
    private BigDecimal price;
    private String description;
    private Date year;
    private MultipartFile image;
    private byte[] returnedImage;
}
