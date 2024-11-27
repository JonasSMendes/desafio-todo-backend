package br.com.jonasSm.desafio_ToDo.repository;

import br.com.jonasSm.desafio_ToDo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
