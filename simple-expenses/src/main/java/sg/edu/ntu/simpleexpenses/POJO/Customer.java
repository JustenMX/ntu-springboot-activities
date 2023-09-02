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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @NonNull
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @NonNull
    @Column(name = "year_of_birth", nullable = false)
    private Integer yearOfBirth;

    /**
     * ONE-TO-MANY BIDIRECTIONAL
     * Parent Entity
     */

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Expenses> expenses;

}
