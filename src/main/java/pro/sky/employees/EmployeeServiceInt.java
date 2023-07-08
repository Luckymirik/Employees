package pro.sky.employees;

import java.util.Collection;

public interface EmployeeServiceInt {
    Employee add(String name,String surname);
    Employee delete(String name,String surname);
    Employee search(String name,String surname);

    Collection<Employee> findAll();
}
