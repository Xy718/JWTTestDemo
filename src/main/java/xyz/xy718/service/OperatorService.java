package xyz.xy718.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.xy718.model.Operator;
import xyz.xy718.repository.OperatorRepository;
import xyz.xy718.repository.RoleOperatorRepository;

@Service
public class OperatorService {

	@Resource
	RoleOperatorRepository roleOperatorRepository;
	@Resource
	OperatorRepository operatorRepository;
	
	public List<Operator> getOpersByRoleID(int role_id){
		return operatorRepository.findOperatorsByRole_id(role_id);
	}
}
