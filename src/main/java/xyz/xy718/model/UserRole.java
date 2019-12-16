package xyz.xy718.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class UserRole {

	@Column
	private int user_id;
	@Column
	private int role_id;
}
