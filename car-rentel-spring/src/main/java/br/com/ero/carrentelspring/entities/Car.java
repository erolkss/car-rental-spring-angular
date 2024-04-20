package br.com.ero.carrentelspring.entities;

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
}
