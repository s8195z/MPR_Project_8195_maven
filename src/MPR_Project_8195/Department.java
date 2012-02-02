package MPR_Project_8195;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;


@Entity
public class Department {

	@Id
	@GeneratedValue
	
	private int ID_department;
	private String Name;

	public Department(int id_department, String name) {
		
		this.ID_department = id_department;
		this.Name=name;	
	}
	
	@ManyToOne
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}


	
	public Integer getID_department() {
		return ID_department;
	}

	public void setID_department(int id_department) {
		this.ID_department = id_department;
		
	}

	@Override
	public String toString () {
		return "ID dzia³u: " + ID_department + ". Name: " + Name;
	}
	
    //zamiast funkcji
	//public void printDepartment()
	//{
	//	System.out.println("ID dzaï¿½u: " + ID_department +". Name: " +Name);
	//}

   }

