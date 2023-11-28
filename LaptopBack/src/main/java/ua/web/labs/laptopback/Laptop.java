package ua.web.labs.laptopback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    private Long id;
    private String company;
    private String model;
    private String properties;
    private Integer price;
    private Integer screenSize;
}