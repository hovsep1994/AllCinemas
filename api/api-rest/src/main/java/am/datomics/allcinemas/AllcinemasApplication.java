package am.datomics.allcinemas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AllcinemasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllcinemasApplication.class, args);
    }

}
