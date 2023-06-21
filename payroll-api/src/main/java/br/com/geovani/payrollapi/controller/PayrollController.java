package br.com.geovani.payrollapi.controller;

import br.com.geovani.payrollapi.model.Payroll;
import br.com.geovani.payrollapi.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollController {

    @Autowired
    private PayrollService PayrollService;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(PayrollService.getPayment(workerId, payment));
    }
}