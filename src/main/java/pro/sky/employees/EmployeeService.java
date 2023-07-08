package pro.sky.employees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInt {
    private final int SIZE=10;

    private final List<Employee> employees = new ArrayList<>(SIZE);
    @Override
    public Employee add(String name,String surname){
        Employee employee = new Employee(name,surname);
        if(employees.size()>SIZE){
            throw new EmployeeStorageIsFullException();
        }
        for (Employee e: employees) {
            if(e.equals(employee)){
                throw new EmployeeAlreadyAddedException();
            }

        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee delete(String name,String surname){
     Employee employee = new Employee(name,surname);
     if(employees.contains(employee)) {
         employees.remove(employee);
         return employee;
     }
     throw new EmployeeNotFoundException();
    }
    @Override
    public Employee search(String name,String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }
}
