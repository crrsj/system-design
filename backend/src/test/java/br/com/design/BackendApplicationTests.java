package br.com.design;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {
	@Disabled("Teste de contexto depende da infraestrutura externa")
	@Test
	void contextLoads() {
	}

}
