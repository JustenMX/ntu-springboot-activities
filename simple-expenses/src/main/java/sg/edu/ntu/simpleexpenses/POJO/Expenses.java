package sg.edu.ntu.simpleexpenses.POJO;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expenses {
    private final String id;
    private String description;
    private Double amount;
    private String category;

    public Expenses(String id, String description, Double amount, String category) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

}
