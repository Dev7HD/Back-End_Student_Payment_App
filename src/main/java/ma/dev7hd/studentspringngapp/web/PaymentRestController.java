package ma.dev7hd.studentspringngapp.web;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import ma.dev7hd.studentspringngapp.dtos.NewPaymentDTO;
import ma.dev7hd.studentspringngapp.entities.Payment;
import ma.dev7hd.studentspringngapp.enumirat.PaymentStatus;
import ma.dev7hd.studentspringngapp.enumirat.PaymentType;
import ma.dev7hd.studentspringngapp.repositories.PaymentRepository;
import ma.dev7hd.studentspringngapp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class PaymentRestController {
    private PaymentRepository paymentRepository;
    private PaymentService paymentService;

    /**
     * Get all payments
     * @return List<Payment>
     */
    @GetMapping(path = "/payments/all")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }

    /**
     * Get all student payments by student code
     * @param code is a student code
     * @return List<Payment>
     */
    @GetMapping(path = "/payments/student/{code}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public List<Payment> allStudentPayments(@PathVariable String code) {
        return paymentRepository.findByStudentCode(code);
    }

    /**
     * Get the payment by its id
     * @param id is the payment id
     * @return Payment or null if doesn't exist
     */
    @GetMapping(path = "/payment")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public Optional<Payment> paymentById(String id) {
        return paymentRepository.findById(id);
    }

    /**
     * Get all payments by the status
     * @param paymentStatus is the payment status
     * @return List<Payment>
     */
    @GetMapping(path = "/payments/status/{status}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public List<Payment> paymentByStatus(@PathVariable(name = "status") PaymentStatus paymentStatus) {
        return paymentRepository.findByStatus(paymentStatus);
    }

    /**
     * Get all payments knowing the type
     * @param paymentType is the payment type
     * @return List<Payment>
     */
    @GetMapping(path = "/payments/type/{type}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public List<Payment> paymentByType(@PathVariable(name = "type") PaymentType paymentType) {
        return paymentRepository.findByType(paymentType);
    }

    /**
     * Update the payment status
     * @param id is payment id
     * @param status is the new status
     * @return Optional<Payment>
     */
    @PutMapping("/payments/{id}")
    public ResponseEntity<Payment> paymentStatusUpdate(@PathVariable String id,@RequestParam PaymentStatus status) {
        return paymentService.paymentStatusUpdate(id,status);
    }

    /**
     * Add new payment
     * @param newPaymentDTO is the object that contains the payment information
     * @param file is the payment receipt
     * @return ResponseEntity<Payment>
     * @throws IOException in case exception on uploading receipt
     */
    @PostMapping(value = "/payments/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Payment> addNewPayment(NewPaymentDTO newPaymentDTO, @Parameter(description = "PDF to upload") @RequestPart(value = "file")MultipartFile file) throws IOException {
        return paymentService.newPayment(newPaymentDTO,file);
    }

    /**
     * Get the payment file
     * @param paymentId is the payment id
     * @return byte[]
     * @throws IOException in case exception on reading receipt
     */
    @GetMapping(path = "/paymentFile/{paymentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable String paymentId) throws IOException {
        return paymentService.getPaymentFile(paymentId);
    }

}
