package parameters;

import org.testng.annotations.Test;

import Genericutilities.Javautility;
import Pojoclass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class RequestchainingGet {
	
	@Test
	public void requestChainingForGet()
	{
		Javautility jLib = new Javautility(); 
		baseURI = "http://localhost";
		port = 8084;
		
		//this is first request to create a project
		ProjectLibrary pLib = new ProjectLibrary("manoj", "tesla"+jLib.getRandomNumber(), "ongoing", 88);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post("/addProject");
		
		//capture the project id using json path
		String myProjID = res.jsonPath().get("projectId");
		System.out.println(myProjID);
		
		res.then().log().all();
	
		//this is second request to read the same project created in 1st request
		given()
		.pathParam("projID", myProjID)
		
		.when()
		.get("/projects/{projID}")
		
		.then().assertThat().statusCode(200).log().all();
	}

}
