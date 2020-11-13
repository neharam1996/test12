package com.tcs.EmployeeApplication;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.EmployeeApplication.config.DBConfig;
import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.model.Employee;
import com.tcs.EmployeeApplication.model.Organization;
import com.tcs.EmployeeApplication.service.DepartmentServices;
import com.tcs.EmployeeApplication.service.EmployeeServices;

import com.tcs.EmployeeApplication.service.OrganizationServices;


public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
		EmployeeServices empservices=context.getBean(EmployeeServices.class);
		DepartmentServices deptservices=context.getBean(DepartmentServices.class);
		OrganizationServices orgservices=context.getBean(OrganizationServices.class);
		 System.out.println("Select an operation you want to perform on Organization\n.1.add\n2.delete\n3.findbyid.\n4.findall\n5.Update");
		 Scanner input2 = new Scanner(System.in);
		 int ans2=input2.nextInt();
		 switch(ans2) {
		 	case 1:{Long id=input2.nextLong();
		 			
		 			String name=input2.next();
		 			String address=input2.next();
		 			Organization org=new Organization(id,name,address,null,null);
		 			System.out.println(orgservices.addOrganization(org));
		 			break;}
		 	case 2:{Long id=input2.nextLong();
		 	System.out.println(orgservices.deleteOrganization(id));
		 			break;}
		 	case 3:{Long id=input2.nextLong();
		 	System.out.println(orgservices.findById(id));
 				break;}
		 	case 4:{System.out.println(orgservices.getOrganizations());break;}
		 	case 5:{Long id=input2.nextLong();
 			
 			String name=input2.next();
 			System.out.println(orgservices.updateOrganization(id, name));break;}
		 	default:
		
		
		 }
		 System.out.println("Select an operation you want to perform on Department\n.1.add\n2.delete\n3.findbyid.\n4.findall\n5.findbyorgid\n6.update");
		 Scanner input1 = new Scanner(System.in);
		 int ans1=input1.nextInt();
		 switch(ans1) {
		 	case 1:{Long id=input1.nextLong();
		 			Long orgid=input1.nextLong();
		 			
		 			String name=input1.next();
		 			Department dept=new Department(id,orgid,name,null);
		 			System.out.println(deptservices.addDepartment(dept));
		 			break;}
		 	case 2:{Long id=input1.nextLong();
		 	System.out.println(deptservices.deleteDepartment(id));
		 			break;}
		 	case 3:{Long id=input1.nextLong();
		 	System.out.println(deptservices.findById(id));
 				break;}
		 	case 4:{System.out.println(deptservices.getDepartments());break;}
		 	case 5:{Long id=input1.nextLong();
		 	System.out.println(deptservices.findByOrganizationId(id));
		 	break;
		 	}
		 	case 6:{Long id=input2.nextLong();
 			
 			String name=input2.next();
 			System.out.println(deptservices.updateDepartment(id, name));break;}
		 	default:
		
		 	
		
		
		 }
		System.out.println("Select an operation you want to perform on Employee\n.1.add\n2.delete\n3.findbyid.\n4.findall\n5.findbyorgid\n6.update");
		 Scanner input = new Scanner(System.in);
		 int ans=input.nextInt();
		 switch(ans) {
		 	case 1:{Long id=input.nextLong();
		 			Long orgid=input.nextLong();
		 			Long deptid=input.nextLong();
		 			String name=input.next();
		 			int age=input.nextInt();
		 			String position=input.next();
		 			Employee employee=new Employee(id,orgid,deptid,name,age,position);
		 			System.out.println(empservices.addEmployee(employee));
		 			break;}
		 	case 2:{Long id=input.nextLong();
		 			System.out.println(empservices.deleteEmployee(id));
		 			break;}
		 	case 3:{Long id=input.nextLong();
 				System.out.println(empservices.findById(id));
 				break;}
		 	case 4:{System.out.println(empservices.getEmployees());break;}
		 	case 5:{Long id=input.nextLong();
		 			System.out.println(empservices.findByOrganization(id));break;
		 	
		 	}
		 	case 6:{Long id=input2.nextLong();
 			
 			String name=input2.next();
 			System.out.println(empservices.updateEmployee(id, name));break;}
		 	default:
		
		
		 }
		 
		
		
		
		
	}
}
