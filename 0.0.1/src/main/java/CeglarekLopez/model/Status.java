package CeglarekLopez.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="status")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="status_name")
    private String statusName;


}
