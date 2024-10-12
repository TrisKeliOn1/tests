package br.com.spring.Rest_With_Spring.repositories;

import br.com.spring.Rest_With_Spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
