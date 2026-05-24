package br.com.fiap.clyvovet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClyvovetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClyvovetApplication.class, args);
        System.out.println("ClyvoVet API is running!");
        System.out.println("Swagger UI: http://localhost:8080/swagger-ui.html");
    }
}


