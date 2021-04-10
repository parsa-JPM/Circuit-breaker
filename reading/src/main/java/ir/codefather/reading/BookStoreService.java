package ir.codefather.reading;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookStoreService {

    @Autowired
    private RestTemplate rest;

    @HystrixCommand(fallbackMethod = "reliable")
    public String getBooks() {
       return rest.getForEntity("http://localhost:8080/recomanded", String.class).getBody();
    }

    public String reliable() {
        return "Deafault books";
    }
}
