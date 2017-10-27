
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.config.EncoderConfig.encoderConfig;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;

import org.junit.Before;
import org.junit.Test;

public class LocationService {
    
    final String baseURI = "http://192.168.1.87:9190/frontend/1.0.0-SNAPSHOT/management-panel/#/";
    
    @Before
    public void setUp() {
        RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.baseURI = baseURI;
    }
    
    @Test
    public void testCreateNewLocation() throws Exception {
        given()
                .formParam("title", "foo")
                .formParam("body", "bodybar")
                .formParam("userId", "1")
                .when()
                .post(baseURI.concat("/locations"))
                .then()
                .statusCode(201);
//                .body("title", equalTo("foo")).body("id", anything());
    }
    
    
}
