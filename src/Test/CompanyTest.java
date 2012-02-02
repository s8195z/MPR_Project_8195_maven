package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import MPR_Project_8195.*;

public class CompanyTest {
	private List<Employee> employees = new ArrayList<Employee>();
    private List<Department> departments = new ArrayList<Department>();
	
    Company company1 = new Company("new"); 
	Company company2 = new Company("Test", employees, departments);
	
	@Before
	public void setUp() throws Exception {
		this.employees = new ArrayList<Employee>();
	    this.departments = new ArrayList<Department>();
		
	    this.company1 = new Company("new"); 
		this.company2 = new Company("Test", employees, departments);
	}
	
	@Test
	public void testCompanyStringListOfEmployeeListOfDepartment() {
		assertEquals(company1.getName(), "new");
	}

	@Test
	public void testGetName() {
		assertEquals("new", company1.getName());
	}

	@Test
	public void testSetName() {
		company1.setName("Test");
        assertEquals("Test", company1.getName());
	}

	@Test
	public void testAddDepartment() {
		departments.add(new Department(1, "Marketing"));
		assertTrue(departments.size() == 1);
	}

	@Test
	public void testAddEmployee() {
		employees.add(new Employee("Adam", "Poniedzia³ek", 1, 689, 54));
		assertTrue(employees.size() == 1);
	}

	@Test
	public void searchEmployeeByPhrase() {
		try {
			assertNotNull(company2.searchEmployeeByPhrase("Adam"));
		} catch (MyException e) {
			assertTrue(true);
		}
	}

	@Test(expected = MyException.class)
	public void searchEmployeeByImie() throws MyException  {
		assertNotNull(company2.searchEmployeeByName("Adam"));
	}

	@Test(expected = MyException.class)
	public void searchEmployeeByNazwisko() throws MyException {
		assertNotNull(company2.searchEmployeeBySurname("Nowak"));
	}

	@Test
	public void deleteEmployee() {
		company2.deleteEmployee(("Poniedzia³ek"));
		assertNotNull(company1.getName());	
	}
	@Test
	public void searchDepartmentByPhrase() {

		company1.addDepartment(new Department(1, "sprzedaz2"));
		assertNotNull(company1.getDepartments());
	}

	@Test(expected = MyException.class)
	public void searchDepartmentByName() throws MyException {
		assertNotNull(company2.searchDepartmentByName("Marketing"));
	}

	@Test
	public void deleteDepartment() {
		company2.deleteDepartment(("Ksiegowosc"));
		assertNotNull(company1.getName());	
	}
}
