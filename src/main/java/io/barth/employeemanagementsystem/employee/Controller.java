package io.barth.employeemanagementsystem.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("employee")
    public String sayHello(){
        return "Hello!";
    }
}
