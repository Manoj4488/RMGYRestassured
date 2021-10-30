package CrudoperatonsBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class Createprojectusingjsonfile {
	@Test
	public void createprojectusingjsonfile() throws FileNotFoundException {
		FileInputStream fis=new FileInputStream("./rmgdata.json");
		
		//request specification
		given()
		.contentType(ContentType.JSON)
	    .body(fis)
	    
	  //actual request
	    .when()
	    .post("http://localhost:8084/addProject")
	    
	  //validation
	    .then()
	    .statusCode(201)
	    .log().all();
				
	}
}
