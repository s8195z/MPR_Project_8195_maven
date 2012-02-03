package MPR_Project_8195;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import javax.persistence.Entity;

@Entity
public class Employee {
	public  int id;
	private String name;
	private  String surname;
	private  double salary;
	private int age;
	private Company company;
	private List<Department> departments = new ArrayList<Department>();
	
	protected Employee() {
		
	}
    public Employee(String name, String surname, int id, double salary, int age)  
      {
           this.name=name;
           this.surname=surname;
           this.id=id;
           this.salary=salary;
           this.age=age;
     }
  
    public String getName(){
          return name;
       }

    public void setName(String Name){
    	   Name = name;
      }

       
    public String getSurname() {
         return this.surname;
      }
    public void setSurname(String surname){
         this.surname=surname;
      }
      
  	@Id
	@GeneratedValue
    public int getID(){
        return this.id;
     }

    public void setID(int id){
        this.id=id;
     }
    
    public int getAge(){
         return this.age;
      }

    public void setAge(int age){
         this.age=age;
      }
     
 
    public double getSalary()
      {
            return this.salary;
}
    public void setSalary(double salary){
        this.salary=salary;
    }
    
    
    @OneToMany(mappedBy="company")
    public List<Department> getDepartments() {
        return departments;
    }
    
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department){
        departments.add(department);
        department.setEmployee(this);
    }

    
    @ManyToOne
    @JoinColumn(name="company_foreign_key")
    public Company getCompany() {
    	return company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
      
    
    @Override
    public String toString () {
    	return "\nID: "+id+"\n Imie½: "+name+"\n Nazwisko: "+surname+"\n Wynagrodzenie: "+salary+"\n Wiek: "+age+"\n ";
    }
    
}  
