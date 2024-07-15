package ma.dev7hd.studentspringngapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Student {
    @Id @UuidGenerator
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(unique = true)
    private String code;
    private String programId;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Payment> payments;
}
