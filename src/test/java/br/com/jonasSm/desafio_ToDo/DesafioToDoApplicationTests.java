package br.com.jonasSm.desafio_ToDo;

import br.com.jonasSm.desafio_ToDo.entity.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioToDoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;



	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("Todo 2 Up", "Todo 2 Up", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$[0].length()").isEqualTo(5)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.getRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testCreateTodoFailure() {
	}

}
