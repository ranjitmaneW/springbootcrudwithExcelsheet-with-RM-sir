package com.ex1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceIMPL implements EmpService {
	@Autowired
	EmpRepo rs;
	
	
	

	@Override
	public void saveData(Emp1 emp) {
	
		
         rs.save(emp);
			
	
	}



	@Override
	public List<Emp1> allEMPdisp() {
		// TODO Auto-generated method stub
		
		
		
		return rs.findAll();
	}



	@Override
	public void EmpdeleteById(int id) {
		// TODO Auto-generated method stub
		rs.deleteById(id);
		
		
	}



	@Override
	public Emp1 getEmpById(int id) {
	Optional<Emp1> FindById	=rs.findById(id);
	     Emp1 emp     =   FindById.get();
	
		return emp;
	}
	
	
	
	
	
	
	
	


/*

	@Override
	public Emp1 getEmpById(int id) {
		
		
		
	Optional<Emp1> findById=     rs.findById(id);
		
		
		Emp1 s =findById.get();
		
		return s;
	}
*/
}
