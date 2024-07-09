package mylambdaprac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
	public static void main(String args[]){
		Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
		printUpperCase.accept("hello1");
		Predicate<Integer> isEven = num -> num % 2 == 0;
		System.out.println(isEven.test(4)); // Output: true
		System.out.println(isEven.test(7)); // Output: false
		Predicate<Integer> isGreaterThanTen = num -> num > 10;
		Predicate<Integer> isEvenAndGreaterThanTen = isEven.and(isGreaterThanTen);
		System.out.println(isEvenAndGreaterThanTen.test(12)); // Output: true
		Predicate<Integer> isOddOrLessThanFive = isEven.negate().or(num -> num < 5);
		System.out.println(isOddOrLessThanFive.test(3)); // Output: true
		Supplier<Double> randomNumberSupplier = Math::random;
		System.out.println(randomNumberSupplier.get()); 
		Supplier<String> greetingsSupplier = () -> {
		    String[] greetings = {"Hello", "Bonjour", "Hola", "Namaste"};
		    int randomIndex =  (((int) (Math.random() * 10)) % greetings.length );
		    return greetings[randomIndex];
		};
		System.out.println(greetingsSupplier.get()); 
		
		List<Integer> numbers = Arrays.asList(10, 12, 15);
		//	numbers.forEach(num -> System.out.println(num));
		Consumer<Integer> num = System.out::println;
		numbers.forEach(num);
		List<String> emails = Arrays.asList("abc1@gmail.com", "abc2@gmail.com");
		  //Store in DB and Send Email Notification
		  Consumer<String> dbConsumer = (email) -> {
		   System.out.println("I am writing into DB :: " + email);
		  };
		  
		  Consumer<String> emailConsumer = (email) -> {
		   System.out.println("I am sending an Email :: " + email);
		  };
		  Consumer<String> dbEmailConsumer = dbConsumer.andThen(emailConsumer);
		  emails.forEach(dbEmailConsumer);
		  Function<Integer, Integer> doubleFunction = x -> x * 2;
		  Function<Integer, Integer> addTwoFunction = x -> x + 2;
		  Function<Integer, Integer> combinedFunction = doubleFunction.compose(addTwoFunction);
		  int result = combinedFunction.apply(5); // first add 2 (5+2) = 7, then double (7*2) = 14
		  System.out.println(result);
	}
	public void consumerExample() {
        Consumer<String> consumer = (name) -> System.out.println("This is my name ->  " + name);
        consumer.accept("bhairab");
        Test consumerDemo = new Test();
        consumerDemo.consumerExample();
        consumerDemo.consumerExample2();
    }

    // consumer with side effect
    public void consumerExample2(){
        ArrayList<Integer> number = new ArrayList<>();
        number.add(2);
        number.add(5);
        number.add(10);
        number.add(14);
        number.add(9);
        Consumer<Integer> consumer = (num) -> printItem(num);

        for(Integer num : number){
          consumer.accept(num);
        }
    }

    private void printItem(Integer num){
        System.out.println("The number is " + num);
    }
}
