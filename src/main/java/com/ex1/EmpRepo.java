package com.ex1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepo extends JpaRepository <Emp1,Integer>

{
	
	

}
