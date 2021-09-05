package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String name;
	private String username;
	private String password;


	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
}
