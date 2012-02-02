package MPR_Project_8195;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity


public class Employee {
	@Id
	public  int id;
	private String name;
	private  String surname;
	private  double salary;
	private int age;

	
    public Employee(String name, String surname, int id, double salary, int age)  
      {
           this.name=name;
           this.surname=surname;
           this.id=id;
           this.salary=salary;
           this.age=age;
     }
    @ManyToOne
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

    
    @Override
    public String toString () {
    	return "\nID: "+id+"\n Imie½: "+name+"\n Nazwisko: "+surname+"\n Wynagrodzenie: "+salary+"\n Wiek: "+age+"\n ";
    }
    
}  
