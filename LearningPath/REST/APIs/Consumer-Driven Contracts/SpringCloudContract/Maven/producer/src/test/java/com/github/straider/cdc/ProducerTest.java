package com.github.straider.cdc;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class ProducerTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new FraudDetectionController());
    }

}
