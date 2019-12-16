package xyz.xy718.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class RoleOperator {

	@Id
	@GeneratedValue
	private int key_id;
	@Column
	private int role_id;
	@Column
	private int operator_id;
}
