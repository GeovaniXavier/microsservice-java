package br.com.geovani.payrollapi.service;

import br.com.geovani.payrollapi.exceptions.ObjectNotFoundException;
import br.com.geovani.payrollapi.feinClients.UserFeign;
import br.com.geovani.payrollapi.model.Payroll;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class PayrollService {

    @Autowired
    private Environment environment;

    @Autowired
    private UserFeign userFeign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
        try {
            var user = userFeign.findById(workerId).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                );
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }

}
