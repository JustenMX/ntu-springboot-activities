package sg.edu.ntu.simpleexpenses.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import lombok.NonNull;
// import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "expenses")
// @RequiredArgsConstructor
// @NoArgsConstructor
@Getter
@Setter
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 50, message = "Description must be between 2 and 50 characters")
    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than 0.00")
    @DecimalMax(value = "9999.99", inclusive = true, message = "Amount must be less than or equal to 9999.99")
    @NonNull
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private ExpenseCategory category;

    @PastOrPresent(message = "Expense date should not be in the future")
    @NonNull
    @Column(name = "expense_date", nullable = false)
    private LocalDate expenseDate;

    /**
     * MANY-TO-ONE UNIDIRECTIONAL
     * Child Entity
     */
    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    /*
     * Lombok Builder
     */
    @Builder
    public Expenses(String description, Double amount, ExpenseCategory category, LocalDate expenseDate,
            Customer customer) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.expenseDate = expenseDate;
        this.customer = customer;
    }
}
