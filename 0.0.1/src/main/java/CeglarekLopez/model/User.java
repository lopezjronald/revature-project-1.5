package CeglarekLopez.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private int user_id;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "firstname", nullable = false)
	private String firstname;
	@Column(name = "lastname", nullable = false)
	private String lastname;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "role_id", nullable = false)
	private int role_id;
	

}
