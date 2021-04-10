package ir.codefather.reading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix
@RestController
public class ReadingApplication {

	@Autowired
	private BookStoreService bookStoreService;

	@Bean
	public RestTemplate createRest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping("/reading")
	public String reader() {
		return bookStoreService.getBooks();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReadingApplication.class, args);
	}

}
