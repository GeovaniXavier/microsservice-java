package br.com.geovani.userapi.service;

import br.com.geovani.userapi.exceptions.ObjectNotFoundException;
import br.com.geovani.userapi.model.User;
import br.com.geovani.userapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
