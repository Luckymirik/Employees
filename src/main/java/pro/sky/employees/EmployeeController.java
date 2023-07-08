package pro.sky.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String name,@RequestParam String surname){
        return employeeService.add(name,surname);
    }
    @GetMapping("/delete")
    public Employee delete(@RequestParam String name,@RequestParam String surname){
        return employeeService.delete(name, surname);
    }
    @GetMapping("/search")
    public Employee search(@RequestParam String name,@RequestParam String surname){
        return employeeService.search(name, surname);
    }
    @GetMapping
    public Collection<Employee> findAll(){
        return employeeService.findAll();

    }





}
