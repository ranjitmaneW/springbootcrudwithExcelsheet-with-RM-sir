package com.ex1;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class Contr {
	
	
	@Autowired
	EmpService es;
	//@Autowired
	//EmpRepo  er;
	@RequestMapping("/home")
public String show1() {
	
	
	
	return "home";
			
	
	
	
}
	
	
	
	
	@RequestMapping("/")
	public String did() {
		
			
		return "index";
		
				 
	}
	
	
	@PostMapping("/next")
	public String Call(@ModelAttribute(  ) Emp1 emp) 
	
	{
			

		es.saveData(emp);
		
		return "redirect:/welcome";
		
	}
	

	@RequestMapping("/welcome")
	public String  dataDISP(ModelMap map) {
		
		List<Emp1> l1=es.allEMPdisp();
		
		map.addAttribute("l1", l1);
		
		return "welcome";
		 
				
	}

	@RequestMapping("/delete")
	public String EMPDEL(@RequestParam("id") int id) {
		
		
		es.EmpdeleteById(id);
		
		return "redirect:/welcome";
		
				
	}
	
	
	
	@RequestMapping("/update")
	public String Updatedata(@RequestParam()int id, ModelMap map) 
	
	{
	Emp1 E1=	es.getEmpById(id);
	map.addAttribute("updatekey", E1);	
	
		
		return  "edit";
		
		
	}
	
	
	
	
	
	
	
	
	/*
	@RequestMapping("/update")
	public String update(@RequestParam("id")int id, ModelMap map)
	
	{
			
		Emp1 EmpByid=er.getById(id);
		map.addAttribute("updatedata",EmpByid);
		 
		
		return "edit";
				  
	}
	*/
	
	@PostMapping("/updatedata")
	public String updateDisplay(@ModelAttribute Emp1  emp) 
	{
		
		
		emp.setId(emp.getId());
		emp.setFullname(emp.getFullname());
		emp.setAge(emp.getAge());
		emp.setMobi(emp.getMobi());
		emp.setSEmail(emp.getSEmail());
		
		es.saveData(emp);
		return "redirect:/welcome";
		
		
		
	}
	
	
	
	
	
	
	
	
/*	
	@PostMapping("/updatedata")
	public String updatedata(@ModelAttribute("emp")Emp1 emp)
	
	
	{
		
		Emp1 s = new Emp1();
		s.setId(emp.getId());
		s.setFullname(emp.getFullname());
		s.setSEmail(emp.getSEmail());
		s.setMobi(emp.getMobi());
		s.setAge(emp.getAge());
		
		//er.saveData(emp);
		er.save(emp);
		
		return "redirect:/welcome";
		
		
	}
	

	
*/

    @GetMapping("/download")
    public void downloadExcel(@RequestParam("id") int id, HttpServletResponse response) throws IOException {
        // Retrieve the entity from the database
        Emp1 E1 = es.getEmpById(id);

        if (E1 != null) {
            // Create a workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Employee");

            // Create header row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Full Name");
            header.createCell(2).setCellValue("Email");
            header.createCell(3).setCellValue("Mobile");
            header.createCell(4).setCellValue("Age");

            // Populate the data row
            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(E1.getId());
            dataRow.createCell(1).setCellValue(E1.getFullname());
            dataRow.createCell(2).setCellValue(E1.getSEmail());
            dataRow.createCell(3).setCellValue(E1.getMobi());
            dataRow.createCell(4).setCellValue(E1.getAge());

            // Set the content type and attachment header
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=employee_" + E1.getId() + ".xlsx");

            // Write the workbook to the response output stream
            workbook.write(response.getOutputStream());
            workbook.close();
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.getWriter().write("Employee not found");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    @GetMapping("/downloadAllEmployees")
    public void downloadAllEmployees(HttpServletResponse response) throws IOException {
        // Retrieve all employees from the service
		List<Emp1> l1=es.allEMPdisp();

        // Create a workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employees");

        // Create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Full Name");
        header.createCell(2).setCellValue("Email");
        header.createCell(3).setCellValue("Mobile");
        header.createCell(4).setCellValue("Age");

        // Populate data rows
        int rowNum = 1;
        for (Emp1 employee : l1) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getFullname());
            row.createCell(2).setCellValue(employee.getSEmail());
            row.createCell(3).setCellValue(employee.getMobi());
            row.createCell(4).setCellValue(employee.getAge());
        }

        // Set the content type and attachment header
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");

        // Write the workbook to the response output stream
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
    

	
	

