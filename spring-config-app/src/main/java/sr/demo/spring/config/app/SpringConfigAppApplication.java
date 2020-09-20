package sr.demo.spring.config.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class SpringConfigAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigAppApplication.class, args);
	}

}
