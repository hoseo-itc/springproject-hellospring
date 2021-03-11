package itc.hoseo.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HellospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}

}
