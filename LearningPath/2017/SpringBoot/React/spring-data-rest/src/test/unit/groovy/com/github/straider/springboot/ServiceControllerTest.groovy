package com.github.straider.springboot

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.hamcrest.CoreMatchers.containsString
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith( SpringRunner.class )
@WebMvcTest
class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc

    @Test
    void shouldProvideHealthCheck() throws Exception {
        mockMvc
                .perform( get( ServiceController.TOP_PATH + ServiceController.HEALTH_PATH )
                        .contentType( MediaType.TEXT_PLAIN_VALUE )
                        .accept( MediaType.TEXT_PLAIN_VALUE )
                )
                .andExpect( status().isOk() )
                .andExpect( content().string( containsString( 'OK' ) ) )
    }

    @Test
    void shouldKnowThymeleafTemplate() throws Exception {
        mockMvc
                .perform( get( ServiceController.TOP_PATH + ServiceController.UI_PATH )
                .contentType( MediaType.TEXT_PLAIN_VALUE )
                .accept( MediaType.TEXT_PLAIN_VALUE )
        )
                .andExpect( status().isOk() )
                .andExpect( content().string( containsString( 'ui' ) ) )
    }

}
