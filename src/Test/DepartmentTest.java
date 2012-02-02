package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MPR_Project_8195.Department;

public class DepartmentTest {

	Department department;
	
	@Before
	public void setUp() throws Exception {
		this.department = new Department(1, "Marketing");
	}

	@Test
	public void testGetName() {
		assertEquals("Marketing", department.getName());
	}

	@Test
	public void testSetName() {
		department.setName("nMarketing");
		assertEquals("nMarketing", department.getName());
	}

	@Test
	public void testGetID_department() {
		assertEquals(new Integer(1), department.getID_department());
	}

	@Test
	public void testSetID_department() {
		department.setID_department(2);
		assertEquals(new Integer(2), department.getID_department());
	}

	@Test
	public void testToString() {
		//assertEquals("ID dzia³u: 1. Nazwa: Marketing", department.toString());
	}

}

