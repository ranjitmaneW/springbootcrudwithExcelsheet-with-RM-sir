package com.ex1;

import java.util.List;

public interface EmpService {
	
	void saveData(Emp1 emp);
	
	
	
	
	List<Emp1>allEMPdisp();
	
	void EmpdeleteById(int id);
	
	Emp1 getEmpById(int id);
	
	
	//
	
	//Emp1 getEmpById(int id);
	

}
