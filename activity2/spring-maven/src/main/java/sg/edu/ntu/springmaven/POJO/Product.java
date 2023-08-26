package sg.edu.ntu.springmaven.POJO;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final String id;

    private String name;
    private double price;
    private String description;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    // Constructor
    public Product(String id, String name, double price, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.description = description;
    }

}
