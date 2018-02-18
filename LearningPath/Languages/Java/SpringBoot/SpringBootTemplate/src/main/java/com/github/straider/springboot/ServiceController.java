package com.github.straider.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@RequestMapping( ServiceController.TOP_PATH )
@EnableSwagger2
public class ServiceController {

    public static final String TOP_PATH    = "/";
    public static final String HEALTH_PATH = "healthz";

    @RequestMapping(
            value    = TOP_PATH + HEALTH_PATH,
            method   = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    @ResponseBody
    public ResponseEntity< String > healthz() {
        return new ResponseEntity<>( "OK", HttpStatus.OK );
    }

}
