package mylambdaprac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test1 {
	static Consumer<String> fobj1 = s -> System.out.println("Hello " + s);
	static StudentFactory   fobj2 = Student::new;
	static Student student = new Student("John");
    static Supplier<String> supplier = student::name;
    static Supplier<Student> employeeSupplierLambda = () -> new Student("Santiago");
    static Student employeeFromLambda = employeeSupplierLambda.get();
    static Supplier<Student> employeeSupplierMethodRef = Student::new;
    static Predicate<String> predicate = StringUtils::startWithUppercase;
    static boolean result = predicate.test("Hello");
    static BiFunction<String, Integer, Student> personConstructor = Student::new;
    static Student person = personConstructor.apply("John", 25);
    static String str = "hello";
    static Function<Integer, Character> f = str::charAt;

	
	public static void main(String args[]){
		List<String> arrlist = Arrays.asList("a", "b", "c"); 
		fobj1.accept("Glenn"); 
		System.out.println(fobj2.create("Glenn").name());
        String name = supplier.get();
        System.out.println(name);
        System.out.println(result);
        System.out.println(person.name());
        System.out.println(person.id());
        arrlist.forEach(System.out::print);
        System.out.println(employeeFromLambda.name());
        System.out.println(employeeSupplierMethodRef.get().name());
        System.out.println(f.apply(0));
        print(String::toLowerCase, "STRING TO LOWERCASE");
        print(s -> s.toLowerCase(), "STRING TO LOWERCASE");
        print(new Function<String, String>(){
           @Override
           public String apply(String s){                             
              return s.toLowerCase();
           }
        }, "STRING TO LOWERCASE");
        
        Supplier<Student> supp = Student::new;
        System.out.println(supp.get());
        Function<String, Student> function = Student::new;
        System.out.println(function.apply("john").name());
        // Define a Supplier that performs a costly computation
        Supplier<String> costlyComputation = () -> {
            System.out.println("Performing costly computation...");
            return "Result of costly computation";
        };
        // The costly computation is not performed until get() is called
        System.out.println("Before calling get()");
        System.out.println(costlyComputation.get()); // Computation happens here
        System.out.println("After calling get()");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        List<Integer> evenNumbers = filter(numbers, isEven);
        System.out.println("Even numbers: " + evenNumbers);
        numbers.forEach(Test1::printNumber);
        Test1 t = new Test1();
        numbers.forEach(t::number);
        Supplier<Student> personSupplier = Student::new;
        Student person = personSupplier.get();  // This will cause a compilation error as there's no no-arg constructor
        System.out.println(person);
        // Correct way: Using Function to create a Person with one argument
        Function<String, Student> personFactory = Student::new;
        Student john = personFactory.apply("John Doe");
        System.out.println(john);
        // Creating a list of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // Creating a list of Person objects using the constructor reference
        List<Student> people = names.stream()
                .map(personFactory)
                .collect(Collectors.toList());
        // Printing the list of Person objects
        people.forEach(e -> System.out.println(e.name()));
        people.forEach(System.out::print);
	}
	
	public static void print(Function<String, String> function, String s){
	      System.out.println(function.apply(s));
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if(predicate.test(element)){
                result.add(element);
            }
        }
        return result;
    }
	
	public static void printNumber(Integer number) {
        System.out.println(number);
    }
	
	public void number(Integer number) {
        System.out.println(number);
    }
}

