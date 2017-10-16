package ro.sci.onlinelibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("ro.sci.onlinelibrary")
@MapperScan("ro.sci.onlinelibrary.repository")
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("server.port", 8181);
        SpringApplication.run(Main.class, args);
    }
}