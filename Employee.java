package lamdaexpert;

import java.util.function.BiFunction;
import java.util.function.Predicate;
// Method references improve code readability and conciseness and
// sometimes some added performance benefits which improves 
// garbage collection ,by removing the boilerplate code required to define a lambda expression 
// for a method that already has a name.
class Employee {
    private String name;
    private Integer age;
    
    Employee(String  name){
    	this.name = name;
    }
    
    Employee(String name, Integer age){
    	this.name = name;
    	this.age = age;
    }
    
    public String name() {
    	return this.name;
    }
    
    public int age() {
    	return this.age.intValue();
    }
    
    public static void main(String args[]) {
    	EmployeeFactory employeeFactory = Employee::new; // Method reference
    	Employee employee = employeeFactory.create("Santiago");
    	System.out.println(employee.name());
    	BiFunction<String, Integer, Employee> personConstructor = Employee::new;
        Employee person = personConstructor.apply("John", 25);
        System.out.println(person.name());
        System.out.println(person.age());
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        Predicate<Integer> isDivisibleBy4 = (n) -> n % 4 == 0;
        Predicate<Integer> isEvenAndIsDivisibleBy4 = isEven.and(isDivisibleBy4);
        System.out.println(isEvenAndIsDivisibleBy4.test(8));
        System.out.println(isEvenAndIsDivisibleBy4.test(6));
        Predicate<Integer> isEvenOrIsDivisibleBy4 = isEven.or(isDivisibleBy4);
        System.out.println(isEvenOrIsDivisibleBy4.test(6));
    }
}
