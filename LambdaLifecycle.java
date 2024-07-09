package mylambdaprac;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaLifecycle {
	public static void main(String args[]) {
	    Consumer<String> lambdaPrinter = str -> System.out.println(str);
	    Printer myPrinter = new Printer();
	     lambdaPrinter.accept("Hello world!");
	     myPrinter.accept("Hello world!!!");
	     Calculator add = (a, b) -> a + b;
	     Calculator subtract = (a, b) -> a - b;
	     System.out.println("10 + 5 = " + add.calculate(10, 5));
	     System.out.println("10 - 5 = " + subtract.calculate(10, 5));
	     List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	        numbers.stream()
	            .filter(n -> n % 2 == 0)
	            .map(n -> n * n)
	            .forEach(System.out::println);
	  }
}

class Printer {
    public void accept(String str) {
      System.out.println(str);
    }
  }

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
