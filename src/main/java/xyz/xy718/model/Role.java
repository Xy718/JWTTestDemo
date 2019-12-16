package xyz.xy718.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Role {

	@Id
	@GeneratedValue
	private int role_id;
	
	@Column(nullable = false)
	private String role_name;
	
	private String remark;
	
	@Column(nullable = false)
	private Date create_time;
	
	private Date modify_time;

}
