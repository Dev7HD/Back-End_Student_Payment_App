package ma.dev7hd.studentspringngapp.web;

import lombok.AllArgsConstructor;
import ma.dev7hd.studentspringngapp.entities.Student;
import ma.dev7hd.studentspringngapp.repositories.StudentRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class StudentRestController {
    private StudentRepository studentRepository;

    /**
     * Find all students
     * @return List<Student>
     */
    @GetMapping(path = "/students/all")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Find all students by program
     * @param programId is student program id
     * @return List<Student>
     */
    @GetMapping(path = "/student/program/{programId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public List<Student> getStudentsByProgramId(@PathVariable String programId) {
        return studentRepository.findStudentByProgramId(programId);
    }

    /**
     * Find student by his code
     * @param code is student code
     * @return Optional<Student>
     */
    @GetMapping(path = "/student/{code}")
    public Optional<Student> getStudentByCode(@PathVariable String code) {
        return studentRepository.findStudentByCode(code);
    }


}
