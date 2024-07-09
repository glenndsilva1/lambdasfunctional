package lamdaexpert;

@FunctionalInterface
interface EmployeeFactory {
    Employee create(String name);
}
