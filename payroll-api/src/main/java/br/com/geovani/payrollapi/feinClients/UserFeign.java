package br.com.geovani.payrollapi.feinClients;

import br.com.geovani.payrollapi.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api")
public interface UserFeign {

    @GetMapping(value = "/api/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping
    public ResponseEntity<List<User>> findAll();

}
