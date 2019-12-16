package xyz.xy718.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class RoleOperator {

	@Column
	private int role_id;
	@Column
	private int operator_id;
}
