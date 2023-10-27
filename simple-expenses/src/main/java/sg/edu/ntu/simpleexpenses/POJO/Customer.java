package sg.edu.ntu.simpleexpenses.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Invalid characters in the username")
    @NonNull
    private String userName;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid characters in the first name")
    @NonNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid characters in the last name")
    @NonNull
    private String lastName;

    @Column(name = "email", nullable = false)
    @NonNull
    @Email(message = "email should be valid")
    private String email;

    @Column(name = "contact_no", nullable = false)
    @Size(min = 8, max = 20, message = "Contact number must be between 8 and 20 characters")
    @NonNull
    private String contactNo;

    @Column(name = "job_title", nullable = false)
    @Size(min = 2, max = 20, message = "job title must be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid characters in the job title")
    @NonNull
    private String jobTitle;

    @Max(value = 2005, message = "Year of birth should not be later than 2005")
    @Min(value = 1940, message = "Year of birth should not be earlier than 1940")
    @NonNull
    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    /**
     * ONE-TO-MANY BIDIRECTIONAL
     * Parent Entity
     * One Customer (Parent Entity) can have multiple expenses
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
