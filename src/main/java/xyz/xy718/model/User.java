package xyz.xy718.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private int user_id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private String salt;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private int status;
	
	private Date last_login_time;
	
	@Column(nullable = false)
	private Date create_time;
	
	private Date modify_time;
	
	public User(int user_id, String username, String password, String salt, String email, int status,
			Date last_login_time, Date create_time, Date modify_time) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.email = email;
		this.status = status;
		this.last_login_time = last_login_time;
		this.create_time = create_time;
		this.modify_time = modify_time;
	}

	public User() {
	}
	
}
