package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import MPR_Project_8195.Employee;

 
public class EmployeeTest {
	Employee employee;

	@Before
	public void setUp() throws Exception {
		this.employee  = new Employee ("Adam", "Poniedzia쿮k", 1, 689, 54); 
	}																		  
	
	@Test
	public void testEmployee() {				
		assertNotNull(employee);
		assertTrue(employee.getName().equals("Adam"));
		assertEquals("Poniedzia쿮k", employee.getSurname());
		assertTrue(employee.getSurname().equals("Poniedzia쿮k"));
	}

	@Test
	public void testGetName() {
		assertEquals("Adam", employee.getName());
	}

	@Test
	public void testSetName() {
		employee.setName("Adam");
		assertEquals("Adam", employee.getName());
	}

	@Test
	public void testGetSurname() {		
		assertEquals("Poniedzia쿮k", employee.getSurname());
	}

	@Test
	public void testSetSurname() {
		employee.setSurname("Nowak");
		assertFalse(employee.getSurname()=="Kowalski");
		assertEquals("Nowak", employee.getSurname());
	}

	@Test
	public void testGetID() {
		assertEquals(1, employee.id);
	}

	@Test
	public void testSetID() {
		employee.setID(1);
		assertEquals(1, employee.id);
	}

	@Test
	public void testGetSalary() {
		assertEquals(689, employee.getSalary(), 0);
	}

	@Test
	public void testSetSalary() {
		employee.setSalary(986);
		assertEquals(986, employee.getSalary(), 0);
	}

	@Test
	public void testToString() {	
	//	assertEquals("\nID: 1\n Name: Adam\n Surname: Poniedzia쿮k\n Salary: 689.0\n Wiek: 54\n", employee.toString());
	}

}
