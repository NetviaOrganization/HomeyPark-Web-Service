package Netvia.SwapServiceAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SwapServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwapServiceApiApplication.class, args);
	}

}
