package soen6441;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import soen6441.Course.Program;

public class ExamQuestion4Test {

	static List<Course> courseNull;
	static List<Course> courses;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		courseNull=null;
		new ExamQuestion4();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetCredits_CourseNull() {
		assertEquals(0, ExamQuestion4.getCredits(courseNull, Program.COMP, "6281"));
	}
	
	
	
	@Test
	public void testGetCredits_Basic_PositiveCase() {		
		assertEquals(4, ExamQuestion4.getCredits(courses, Program.SOEN, "6441"));	
	}
	
	

}
