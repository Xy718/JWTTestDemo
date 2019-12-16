package xyz.xy718.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xyz.xy718.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

	@Query("SELECT"
			+ " * "
			+ "FROM"
			+ " operator "
			+ "WHERE operator.operator_id "
			+ "IN("
			+ "select role_operator.operator_id from role_operator where role_operator.role_id=?1"
			+ ")")
	public List<Operator> findOperatorsByRole_id(int role_id);
}
