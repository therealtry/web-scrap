package sample;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.ApplicationPath;

/**
 * Created by abdul on 10/2/2016.
 */
//@Component
@Configuration
@Controller
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(Endpoint.class);
    }

}
