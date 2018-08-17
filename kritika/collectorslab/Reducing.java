package lambdasinaction.collectors;

import static java.util.stream.Collectors.*;
import static lambdasinaction.collectors.Dish.menu;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Reducing {
	 static Stream<String> names= Stream.of("Pasta", "Fish", "Pasta", "Meat", "Pasta", "Meat");
	 
    public static void main(String ... args) {
       /* System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());*/
        
    	//Q 1.3 lab 11 with collect
        Optional<Dish> dishWithLongestName = menu.stream().collect(maxBy(Comparator.comparing(Dish::getName)));
        System.out.println("with collect :"+dishWithLongestName.get());
        
        //Q 1.3 lab 11 with reduce
        String dishWithLongestName2 = menu.stream().map(Dish::getName)
        									  .reduce("",(d1,d2)-> {if(d1.length()>d2.length()) return d1;
        									  else return d2;});
        System.out.println("with reduce : "+dishWithLongestName2);
        
        //Q1.4
        System.out.println(countWords());
        
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }
    
    private static Map<String, Long> countWords(){
    	return names.collect(groupingBy(names-> names, counting()));
    }
}