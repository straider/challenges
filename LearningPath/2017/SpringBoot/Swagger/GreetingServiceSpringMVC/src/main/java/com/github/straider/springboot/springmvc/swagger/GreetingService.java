package com.github.straider.springboot.springmvc.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Controller
@RequestMapping( "/ws/rest/" )
public class GreetingService {

    private final Greeter greeter;

    public GreetingService() {
        greeter = new Greeter();
    }

    @RequestMapping(
              value    = "speak"
            , method   = RequestMethod.GET
            , consumes = { ALL_VALUE, TEXT_PLAIN_VALUE }
            , produces = TEXT_PLAIN_VALUE
    )
    @ResponseBody
    public String speak( @RequestParam( value = "name", required = false, defaultValue = "" ) final String name ) {
        final String response;
        response = ( "".equals( name ) ) ? greeter.speak() : greeter.speak( name );

        return response;
    }

    @RequestMapping(
              value    = "greeting/{greeting}"
            , method   = RequestMethod.PUT
            , consumes = { ALL_VALUE, TEXT_PLAIN_VALUE }
            , produces = TEXT_PLAIN_VALUE
    )
    @ResponseBody
    public void setGreeting( @PathVariable( value = "greeting" ) final String greeting ) {
        greeter.setGreeting( greeting );
    }

    @RequestMapping(
              value    = "process"
            , method   = RequestMethod.POST
            , consumes = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE }
            , produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE }
    )
    @ResponseBody
    public ResponseModel process( @RequestBody final RequestModel request ) {
        final String message = ( "".equals( request.getName() ) ) ? greeter.speak() : greeter.speak( request.getName() );
        final ResponseModel response = new ResponseModel();
        response.setMessage( message );
        response.setResponseOn();

        return response;
    }

}
