package br.com.fiap.mp.repository;

import br.com.fiap.mp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
}
