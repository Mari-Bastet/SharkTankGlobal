package fiap.br.shark.tank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan("fiap.br.challenge.teste")
//@EnableJpaRepositories("fiap.br.challenge.teste")
public class SharkTankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharkTankApplication.class, args);
	}

}
