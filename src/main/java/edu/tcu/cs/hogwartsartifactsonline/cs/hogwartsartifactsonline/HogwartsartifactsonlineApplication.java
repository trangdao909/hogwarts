package edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline;

import edu.tcu.cs.hogwartsartifactsonline.cs.hogwartsartifactsonline.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// entry point of this app
@SpringBootApplication
public class HogwartsartifactsonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HogwartsartifactsonlineApplication.class, args);
    }

    // create Id automatically
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
