package ar.com.flexia.cv19shared.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.flexia.cv19shared.model.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
	Optional<User> findByUsername(String username);

}