package Crudoperations;

import org.testng.annotations.Test;

import Pojoclass.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Createprojectusingpojoclass {
	@Test
	public void createprojectusingpojo() {
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary pl=new ProjectLibrary("mahesh", "amazon", "started", 8);
		
		//request specification
		given()
	    .contentType(ContentType.JSON)
	    .body(pl)
	    
	  //actual request
	    .when()
	    .post("/addProject")
	    
	  //validation
	    .then()
	    .assertThat()
	    .statusCode(201)
	    .log().all();
	}
}
