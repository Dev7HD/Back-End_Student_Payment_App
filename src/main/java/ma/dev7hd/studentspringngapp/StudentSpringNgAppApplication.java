package ma.dev7hd.studentspringngapp;

import ma.dev7hd.studentspringngapp.entities.Payment;
import ma.dev7hd.studentspringngapp.entities.Student;
import ma.dev7hd.studentspringngapp.enumirat.PaymentStatus;
import ma.dev7hd.studentspringngapp.enumirat.PaymentType;
import ma.dev7hd.studentspringngapp.repositories.PaymentRepository;
import ma.dev7hd.studentspringngapp.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class StudentSpringNgAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSpringNgAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        return args -> {
            studentRepository.save(Student.builder()
                            .firstName("Hamza")
                            .lastName("Damiri")
                            .code("1210113571")
                            .email("hamza.damiri@edu.ma")
                            .programId("II-BDCC")
                    .build());
            studentRepository.save(Student.builder()
                    .firstName("Yassin")
                    .lastName("FADIL")
                    .code("1425161765")
                    .email("yassin.fadil@edu.ma")
                    .programId("II-GLCID")
                    .build());
            studentRepository.save(Student.builder()
                    .firstName("Hind")
                    .lastName("Bakhtari")
                    .code("1210113534")
                    .email("hind.bakhtari@edu.ma")
                    .programId("SMC")
                    .build());
            studentRepository.save(Student.builder()
                    .firstName("Widad")
                    .lastName("Damiri")
                    .code("1627365487")
                    .email("widad.damiri@edu.ma")
                    .programId("SMAI")
                    .build());
            studentRepository.findAll().forEach(student -> {
                for (int i = 0; i < 4; i++) {
                    double random = Math.random();
                    Payment payment = Payment.builder()
                            .amount((int) (random * 10000))
                            .student(student)
                            .date(LocalDate.now())
                            .type(random >= 0.75 ? PaymentType.CASH : random >= 0.5 ? PaymentType.CHECK : random >= 0.25 ? PaymentType.DEPOSIT : PaymentType.TRANSFER)
                            .status(random >= 0.66 ? PaymentStatus.VALIDATED : random >= 0.33 ? PaymentStatus.CREATED : PaymentStatus.REJECTED )
                            .receipt("./static/recipes").build();
                    paymentRepository.save(payment);
                }
            });
        };
    }

}
