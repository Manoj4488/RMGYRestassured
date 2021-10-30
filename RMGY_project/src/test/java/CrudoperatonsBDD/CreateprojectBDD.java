package CrudoperatonsBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;



public class CreateprojectBDD {
	@Test
    public void createproject() {
    	//create json data before request
    	JSONObject jobj=new JSONObject();
    	jobj.put("createdBy", "llll");
    	jobj.put("projectName", "mnm");
    	jobj.put("status", "started");
    	jobj.put("teamSize", 18);
    	
        given()
        .contentType(ContentType.JSON)
        .body(jobj)
        
        .when()
        .post("http://localhost:8084/addProject")
        
        .then()
        .assertThat()
        .statusCode(201)
        .log().all();
        
    	
    }
}
