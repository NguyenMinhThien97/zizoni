package com.example.Run.domain.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Run.domain.entity.New;
@Repository
public interface NewRepository extends JpaRepository<New , Long>{
	@Query(value ="SELECT * FROM New ORDER BY created_date DESC LIMIT 3" , nativeQuery = true)
	List<New> TopNew();

}
