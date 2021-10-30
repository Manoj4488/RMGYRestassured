package Crudoperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Updateproject {
	@Test
    public void updateproject() {
    	//create json data before request
    	JSONObject jobj=new JSONObject();
    	jobj.put("createdBy", "kumar");
    	jobj.put("projectName", "mn1");
    	jobj.put("status", "ongoing");
    	jobj.put("teamSize", 4);
    	
    	//set request specification before request
    	RequestSpecification req=RestAssured.given();
    	req.contentType(ContentType.JSON);
    	req.body(jobj);
    	
    	//send the request
    	Response res=req.put("http://localhost:8084/projects/TY_PROJ_602");
    	res.then().assertThat().statusCode(200);
    	
    	//print the response
    	System.out.println(res.asString());
    	System.out.println(res.prettyPrint());
    	System.out.println(res.prettyPeek());
    	
    }
}
