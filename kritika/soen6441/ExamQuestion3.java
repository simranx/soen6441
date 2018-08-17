package soen6441;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import soen6441.Course.Program;

public class ExamQuestion3 {

	// Subtask a)
	private static CompletionStage<Integer> addCredits (List<Course> courses) {
		int credits = courses.stream().collect(Collectors.summingInt(Course::getCredits));
		CompletableFuture<Integer> future = new CompletableFuture<>();
		future.complete(credits);
		return future;
	}
	
	//Subtask c)
	private static CompletionStage<Boolean> check (Integer sum) {
		CompletableFuture<Boolean> future = new CompletableFuture<>();
		if(sum>50)
			future.complete(true);
		return future;
	}
		
 	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Hello, SOEN6411 Exam Question 3!");
		
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		// Subtask a) -- see method addCredits above
		final CompletionStage<Integer> futureSum = addCredits(courses);
		//System.out.println(futureSum.toCompletableFuture().get());
		
		
		// Subtask b)
		System.out.println(futureSum.toCompletableFuture().join());
		
		// Subtask c)
		final CompletionStage<Boolean> futureStatus = addCredits(courses)
				.thenComposeAsync(c -> check(c));
		System.out.println(futureStatus.toCompletableFuture().get());
		
		System.out.println("Goodbye, SOEN6411 Exam Question 3!");
	}
}
