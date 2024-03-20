package lbu.sesc.student.controller;

import jakarta.persistence.GeneratedValue;
import lbu.sesc.student.model.Student;
import lbu.sesc.student.service.StudentService;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public EntityModel<Student> createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public EntityModel<Student> getStudentJson(@PathVariable Long id){
        return studentService.getStudentByIdJson(id);
    }
}
