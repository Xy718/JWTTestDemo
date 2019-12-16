package xyz.xy718.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserRole {
	@Id
	@GeneratedValue
	private int key_id;
	@Column
	private int userID;
	@Column
	private int role_id;
}
