package CeglarekLopez.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private float amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private int author;
    private int resolver;
    private int statusId;
    private int typeId;

}
