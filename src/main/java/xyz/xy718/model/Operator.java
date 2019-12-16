package xyz.xy718.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Operator {
	@Id
	@GeneratedValue
	private int operator_id;
	
	@Column(nullable = false)
	private String operator_name;
	
	@Column(nullable = false, unique = true)
	private String url;
	
	private String perms;
	
	@Column(nullable = false)
	private String http_method;

	@Column(nullable = false)
	private Date create_time;
	
	private Date modify_time;

	public Operator(int operator_id, String operator_name, String url, String perms, String http_method,
			Date create_time, Date modify_time) {
		super();
		this.operator_id = operator_id;
		this.operator_name = operator_name;
		this.url = url;
		this.perms = perms;
		this.http_method = http_method;
		this.create_time = create_time;
		this.modify_time = modify_time;
	}

	public Operator() {
		super();
	}
	
}
