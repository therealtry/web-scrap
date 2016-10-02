package sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by abdul on 10/2/2016.
 */

@Service
@Repository
public class Cservice {
    @Value("${message:World}")
    private String msg;

    public String message() {
        return this.msg;
    }
}
