package br.com.geovani.userapi.repository;

import br.com.geovani.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
