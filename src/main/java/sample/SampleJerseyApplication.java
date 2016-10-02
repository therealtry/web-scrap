package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by abdul on 10/2/2016.
 */

@EnableAutoConfiguration
@Configuration
@ComponentScan
//@SpringBootApplication(scanBasePackages = {"com.sample"/*, "com.bean"*/})
public class SampleJerseyApplication {

    public static void main(String[] args) {
       /* new SampleJerseyApplication()
                .configure(new SpringApplicationBuilder(SampleJerseyApplication.class))
                .run(args);*/
        SpringApplication.run(SampleJerseyApplication.class,args);
    }
}
