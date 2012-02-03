package MPR_Project_8195;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;


    @Entity
    public class Company {

    	private String name; 
        private List<Employee> employees = new ArrayList<Employee>();
    	private List<Department> departments= new ArrayList<Department>();
    	
    public Company(String name, List<Employee> employees , List<Department> departments)
          {
                   this.name=name;
                   this.employees=employees;
                   this.departments=departments; 
          }
        
    public Company(String name) {
        		super();
        		this.name = name;
        		this.employees = new ArrayList<Employee>();
        		this.departments = new ArrayList<Department>();
        	}

    public String getName() {
        		return name;
        	}
    public void setName(String name) {
        		this.name = name; 
        	}
        	
    public List<Employee> getEmployees() {
        		return employees;
        	}
        	
     	
    public List<Department> getDepartments() {
        		return departments;
        	}
    public void addDepartment(Department department){
        departments.add(department);
        }


        	
    @OneToMany(mappedBy="company")
    public List<Employee> getEmployee() {
                return employees;
            }         
            
    public void setEmployee(List<Employee> employees) {
                this.employees = employees;
            }
            	
    public void addEmployee(Employee employee){
                employees.add(employee);
                employee.setCompany(this);
            }
       

        	
     private void printRegister(List<?> arr) {
        	  for (Object o : arr) {
        		  System.out.println(o);
        	  }
        	  System.out.println();
          }
          
     public void printEmployeesAll () {
        	  System.out.println("Employees: ");
        	  printRegister(employees);
        	  System.out.println(); 
          }
          
     public void printDepartments() {
        	  System.out.println("Departments: ");
        	  printRegister(departments);
        	  System.out.println(); 
          }
          
     public void printAll () {
        	  printDepartments();
        	  printEmployeesAll ();
          }
          
     public void printEmployeeBySurname (String surname) {
        	  try {
        		System.out.println("Employee o nazwisku " + surname + ": ");
				System.out.println(searchEmployeeBySurname(surname) + "\n");
			} catch (MyException e) {
				e.printError();
			}
          }
          
      public void printEmployeeByPhrase (String phrase) {
        	  try {
        		System.out.println("Employee z fraza " + phrase + ": ");
        		printRegister(searchEmployeeByPhrase(phrase));
			} catch (MyException e) {
				e.printError();
			}
          }
          
      public void printEmployeeByName (String name) {
        	  try {
        		System.out.println("Pracownik o imieniu " + name + ": ");
        		printRegister(searchEmployeeByName(name));
			} catch (MyException e) {
				e.printError();
			}
          }
          

      public void printDepartmentByPhrase(String phrase) {
        	  System.out.println("Dzialy z fraza " + phrase + ": ");
        	  try {
				printRegister(searchDepartmentByPhrase(phrase));
			} catch (MyException e) {
				e.printError();
			}
          }
    	  
          
      public void printDepartmentByName(String name) {
        	  System.out.println("Department o nazwie " + name + ": ");
        	  try {
				System.out.println(searchDepartmentByName(name));
				System.out.println();
			} catch (MyException e) {
				e.printError();
			}
          }
          

          
      public ArrayList<Employee> searchEmployeeByPhrase (String phrase) throws MyException {
        	  
        	  ArrayList<Employee> arr = new ArrayList<Employee>();
        	  
        	  for (Employee e : employees) {
        		  if (e.getName().toLowerCase().indexOf(phrase.toLowerCase()) != -1
        				  || e.getSurname().toLowerCase().indexOf(phrase) != -1) {
        			  
        			  arr.add(e);
        		  }
        	  }

        	  if (arr.isEmpty()) throw new MyException("Brak pracownika z fraza" + phrase + " w imieniu lub nazwisku.");
        	  else return arr;
          }
          
      public ArrayList<Employee> searchEmployeeByName (String name) throws MyException {
        	  
        	  ArrayList<Employee> arr = new  ArrayList<Employee>();
        	  
        	  for (Employee p : employees) {
        		  if (p.getName() == name) {
        			  arr.add(p);
        		  }
        	  }
        	  
        	  if (arr.isEmpty()) throw new MyException("Brak pracownika o imieniu" + name + ".");
        	  else return arr;
          }
          
      public Employee searchEmployeeBySurname (String surname) throws MyException {
        	  try {
        		  
        		  return getEmplRef(surname);
        	  }
        	  catch (MyException e) {
        		  throw e;
        	  }
          }          
        	
       private Employee getEmplRef (String surname) throws MyException {
        	  
        	  for (Employee e : employees) {
        		  if (e.getSurname() == surname) return e;
        	  }
        	  throw new MyException("Pracownik o nazwisku " + surname + " nie pracuje w firmie.");
          }
          
       public void editEmplWynagrodzenie (String surname, double wynagrodzenie) {
        	  
        	  try {
        		  Employee p = getEmplRef(surname);
        		  p.setSalary(wynagrodzenie);
        		  System.out.println("Pracownik o nazwisku " + surname + " pomyslnie zedytowany.");
        	  }
        	  catch (MyException e) {
        		  e.printError();
        	  }
          }
          
       public void deleteEmployee (String surname) {
        	  
        	  try {
        		  employees.remove(getEmplRef(surname));
        	  }
        	  catch (Exception e) {
        		  System.out.println("Pracownik o nazwisku " + surname + " nie pracuje w firmie.");
        	  }
        	  
          }
 
          
       public ArrayList<Department> searchDepartmentByPhrase (String phrase) throws MyException {
        	  
        	  ArrayList<Department> arr = new ArrayList<Department>();
        	  
        	  for (Department d : departments) {
        		  if (d.getName().toLowerCase().indexOf(phrase.toLowerCase()) != -1) {
        			  arr.add(d);
        		  }
        	  }
        	  if (arr.isEmpty()) throw new MyException("Brak dzialu z fraza" + phrase + " w nazwie.");
        	  else return arr;
          }
          
       public Department searchDepartmentByName (String name) throws MyException {
        	  try {
        		  return getDepartmentRef(name);
        	  }
        	  catch (MyException e) {
        		  throw e;
        	  }
          }
          
       private Department getDepartmentRef (String name) throws MyException {
        	  
        	  for (Department d : departments) {
        		  if (d.getName() == name) return d;
        	  }
        	  throw new MyException("Dzial o nazwie " + name + " nie istnieje w firmie.");
          }
          
       public void editDepartmentName (String oldName, String newName) {
        	  
        	  try {
        		  Department d = getDepartmentRef(oldName);
        		  d.setName(newName);  
        	  }
        	  catch (MyException e) {
        		  e.printError();
        	  }
          }
          
       public void deleteDepartment (String name) {
        	  
        	  try {
        		  departments.remove(getDepartmentRef(name));
        	  }
        	  catch (Exception e) {
        		  System.out.println("Dzial o nazwie " + name + " nie funkcjonuje w firmie.");
        	  }
          }  

    }


