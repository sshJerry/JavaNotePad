package com.main;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.model.Department;
import com.model.Tester;
import com.service.DepartmentService;
import com.service.TesterService;

//import org.eclipse.jdt.internal.compiler.parser.Scanner;

public class App {
	public static void main(String args[]) {
		//Reach out to persistdence.xml
	    EntityManagerFactory entityManagerFactory=null;
		//EntityMagerFactory will help me reach out to persistence.xml
		
	    EntityManager entityManager = null;
		
		//EntityTransaction will help us manage transaction states;
	    EntityTransaction entityTransaction = null;
		
	    entityManagerFactory = Persistence.createEntityManagerFactory("mycompanydb");
		//System.out.println("All good");
	    entityManager = entityManagerFactory.createEntityManager();
	    entityTransaction = entityManager.getTransaction();
	    
	    Scanner sc = new Scanner(System.in);
	    
	    DepartmentService departmentService = new DepartmentService();
	    TesterService testerService = new TesterService();
	    while(true) {
	    	entityTransaction.begin();
	    	System.out.println("-----Employee Ops-----");
	    	System.out.println("1 Insert Tester");
	    	System.out.println("2 Fetch All Tester");
	    	System.out.println("3 Update Tester");
	    	System.out.println("4 Delete Tester");
	    	System.out.println("5 Populate Departments");
	    	System.out.println("6 Show employee in each department");
	    	System.out.println("0 Exit");
	    	
	    	int input = sc.nextInt();
	    	
	    	if(input==0) {
	    		System.out.println("Exut");
	    		break;
	    	}
	    	switch(input) {
	    	case 1:
	    		Tester t = new Tester();
	    		System.out.println("Enter Tester First Name");
	    		t.setFirstName(sc.next());
	    		System.out.println("Enter Tester Last Name");
	    		t.setLastName(sc.next());
	    		
	    		List<Department> listDept = departmentService.fetchAllDepartments(entityManager);
	    		listDept.stream().forEach(d->System.out.println(d));
	    		System.out.println("Enter department ID:");
	    		int did = sc.nextInt();
	    		//go to service and fetch department object based id and deptList
	    		Department dept = departmentService.fetchDeptObject(listDept,did);
	    		t.setDepartment(dept);
	    		
	    		entityManager.persist(t);
	    		System.out.println("Employee Added in DB");
	    		entityTransaction.commit();
	    		break;
	    	case 2:
	    		System.out.println("-----All Employee-----");
	    		TesterService service =new TesterService();
	    		List<Tester> list = service.fetchAllEmployee(entityManager);
	    		for(Tester emp : list) {
	    			System.out.println(emp);
	    		}
	    		entityTransaction.commit();
	    		break;
	    	case 3:
	    		System.out.println("Enter the Tester ID");
	    		int tid = sc.nextInt();
	    		Tester tester = entityManager.find(Tester.class, tid); //id fname lname
	    		if(tester == null) {
	    			System.out.println("Tester ID invalid");
	    			break;
	    		}
	    		System.out.println("Current record: ");
	    		System.out.println(tester); //id(old), fname(old),lname(old)
	    		System.out.println(" ");
	    		System.out.println("Enter Tester First Name: ");
	    		tester.setFirstName(sc.next());//id(old), fname(new),lname(old)
	    		System.out.println("Enter Tester Last Name: ");
	    		tester.setLastName(sc.next());//id(old), fname(new),lname(new)
	    		entityManager.persist(tester);
	    		System.out.println("Tester Recorder Updated");
	    		entityTransaction.commit();
	    		break;
	    
	    		
	    		
	    	case 4:
	    		System.out.println("Enter the Tester ID");
	    		tid =sc.nextInt();
	    		tester = entityManager.find(Tester.class, tid); //id fname lname
	    		if(tester == null) {
	    			System.out.println("Tester ID invalid");
	    			break;
	    		}
	    		entityManager.remove(tester);
	    		System.out.println("Employee Deleted");
	    		entityTransaction.commit();
	    		break;
	    	case 5:
	    		System.out.println("Enter Department Name");
	    		String departmentName =sc.next();
	    		Department department = new Department();
	    		department.setName(departmentName);
	    		entityManager.persist(department);
	    		System.out.println("department added");
	    		entityTransaction.commit();
	    		break;
	    	case 6:
	    		System.out.println("Enter department ID:");
	    		did = sc.nextInt();
	    		
	    		department = entityManager.find(Department.class, did);
	    		if(department == null) {
	    			System.out.println("Tester ID invalid");
	    			entityTransaction.commit();
	    			break;
	    		}
	    		
	    		List<Tester> listTest = testerService.fetchTesterByDepartment(entityManager,did);
	    		listTest.stream().forEach(t1->System.out.println(t1));
	    		entityTransaction.commit();
    			break;
	    		
	    		
	    		
	    		
	    	default:
	    		System.out.println("Invalid Input!");
	    		entityTransaction.commit();
	    		break;
	    	}
	    }
	}
}
