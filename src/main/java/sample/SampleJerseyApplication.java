package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Created by abdul on 10/2/2016.
 */

//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@SpringBootApplication
@Controller
public class SampleJerseyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleJerseyApplication.class,args);
    }
}
