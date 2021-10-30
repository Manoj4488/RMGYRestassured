package CrudoperatonsBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import Genericutilities.Javautility;
import Pojoclass.ProjectLibrary;

import io.restassured.http.ContentType;

public class Createprojpojorandom {
	@Test
	public void createprojectusingpojo() {
		Javautility jlib=new Javautility();
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary pl=new ProjectLibrary("mahesh", "amazon"+jlib.getRandomNumber(), "started", 8);
		
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
