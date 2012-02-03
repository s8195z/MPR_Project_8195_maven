package MPR_Project_8195;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Entity;


@Entity
public class Department {

	private int ID_department;
	private String Name;
	private Employee employee;
	
	protected Department() {}

	public Department(int id_department, String name) {
		
		this.ID_department = id_department;
		this.Name=name;	
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}

	@Id
	@GeneratedValue
	public Integer getID_department() {
		return ID_department;
	}

	public void setID_department(int id_department) {
		this.ID_department = id_department;
		
	}
    
 
    @ManyToOne
    @JoinColumn(name="employee_foreign_key")
    public Employee getEmployee() {
    	return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
	@Override
	public String toString () {
		return "ID dzia³u: " + ID_department + ". Name: " + Name;
	}
	


   }

