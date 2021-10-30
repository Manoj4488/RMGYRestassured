package Crudoperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Getallprojects {
	@Test
    public void createproject() {
		Response res=RestAssured.get("http://localhost:8084/projects");
		System.out.println(res.getContentType());
    	System.out.println(res.getTime());
    	System.out.println(res.statusCode());
    	
    	ValidatableResponse val=res.then();
    	val.assertThat().contentType("application/json");
    	val.assertThat().statusCode(200);
    	res.prettyPrint();
    	res.prettyPeek();
	}
}
