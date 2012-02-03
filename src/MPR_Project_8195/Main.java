package MPR_Project_8195;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.hibernate.classic.Session;


public class Main {

public static void main(String[] args) throws Exception {
  
	  Company company= new Company("KRZAK");

      company.addEmployee(new Employee("Adam","Poniedzialek", 1, 689, 54));
      company.addEmployee(new Employee("Ewa","Nowak", 2, 2700, 39));
      company.addEmployee(new Employee("Jacek","Jutro", 3, 928,  34));
      company.addEmployee(new Employee("Jacek","Wczoraj", 4, 928,  34));
      company.addEmployee(new Employee("Wacek","Testowy", 5, 928,  34));

      company.addDepartment(new Department(1,"Ksiegowosc"));
      company.addDepartment(new Department(2, "Marketing"));
      company.addDepartment(new Department(3, "Sprzedaz"));
      company.addDepartment(new Department(4, "Dlatestowsprzedaz"));
      
      Employee p = new Employee("Adam", "Poniedzialek", 1, 689, 54) ;
      SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
      Session session = sessionFactory.openSession(); 
      session.beginTransaction();
      session.save(p);   
      session.getTransaction().commit();
      session.close();
   
      /* Testowanie dzialow */
  
      //company.printDepartments();
      //company.printDepartmentByName("Marketing"); //istnieje
      //company.deleteDepartment("Marketing");
      //company.printDepartmentByName("Marketing"); //nie istnieje
      //company.printDepartmentByPhrase("daz");
      //company.editDepartmentName("Dlatestowsprzedaz", "Administracja");
      //company.printDepartments();
        
      /* Testowanie pracownikow */
      
      company.printEmployeesAll();
      //company.printEmployeeByName("Jacek");
      //company.printEmployeeByPhrase("cek");
      //company.printEmployeeBySurname"Testowy");
      //company.deleteEmployee("Testowy");
      //company.printEmployeeBySurname("Testowy");
      //company.editEmplSalary("Testowy", 22.0);
      //company.printEmployeeBySurname("Testowy");

   }

 }
      
