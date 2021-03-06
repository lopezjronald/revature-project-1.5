package CeglarekLopez.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reimbursements")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reimbursement {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "submitted")
    private java.sql.Timestamp submitted;

    @Column(name = "resolved")
    private java.sql.Timestamp resolved;

    @Column(name = "description")
    private String description;

    @Column(name = "author_id")
    private int author;

    @Column(name = "resolver_id")
    private int resolver;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "type_id")
    private int typeId;

//    In case we implement a One to many relationship
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;

    public Reimbursement(float amount, Timestamp submitted, Timestamp resolved, String description, int author, int resolver, int statusId, int typeId) {
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.statusId = statusId;
        this.typeId = typeId;
    }
}
