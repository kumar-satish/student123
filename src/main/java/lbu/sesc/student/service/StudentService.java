package lbu.sesc.student.service;

import lbu.sesc.student.StudentRepository;
import lbu.sesc.student.controller.StudentController;
import lbu.sesc.student.model.Student;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public EntityModel<Student> getStudentByIdJson(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with this Id doesn't exist"));
        return EntityModel.of(student, linkTo(methodOn(StudentController.class).getStudentJson(student.getId())).withSelfRel());
    }

    public EntityModel<Student> addStudent(Student student){
        Student student1 = studentRepository.save(student);
        return EntityModel.of(student1);
    }

//    public Student addStudent(Student student){
//        return studentRepository.save(student);
//    }
}
