package Crudoperations;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Createprojectwithhashmap {
@Test
public void createprojectusinghashmap() {
	HashMap map=new HashMap();
	map.put("createdBy", "akhil");
	map.put("projectName", "irctc");
	map.put("status", "started");
	map.put("teamSize", 4);
	
	//request specification
	given()
    .contentType(ContentType.JSON)
    .body(map)
    
    //actual request
    .when()
    .post("http://localhost:8084/addProject")
    
    //validation
    .then()
    .assertThat()
    .statusCode(201)
    .contentType(ContentType.JSON)
    .log().all();
	
}
}
