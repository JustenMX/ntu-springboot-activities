package sg.edu.ntu.simpleexpenses.pojo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import lombok.NonNull;
// import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
// @RequiredArgsConstructor
// @NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Invalid characters in the username")
    @NonNull
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid characters in the first name")
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid characters in the last name")
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "email", nullable = false)
    @Email(message = "email should be valid")
    private String email;

    @Size(min = 8, max = 20, message = "Contact number must be between 8 and 20 characters")
    @NonNull
    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Size(min = 2, max = 20, message = "job title must be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid characters in the job title")
    @NonNull
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Digits(integer = 4, fraction = 0, message = "Invalid year format")
    @NonNull
    @Column(name = "year_of_birth", nullable = false)
    private Integer yearOfBirth;

    /**
     * ONE-TO-MANY BIDIRECTIONAL
     * Parent Entity
     */

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Expenses> expenses;

    /**
     * Lombok Builder
     */
    @Builder
    public Customer(String userName, String firstName, String lastName, String email, String contactNo, String jobTitle,
            Integer yearOfBirth, List<Expenses> expenses) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.jobTitle = jobTitle;
        this.yearOfBirth = yearOfBirth;
        this.expenses = expenses;
    }

}
