package CrudoperatonsBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateprojectBDD {
	@Test
    public void createproject() {
    	//create json data before request
    	JSONObject jobj=new JSONObject();
    	jobj.put("createdBy", "kkkkk");
    	jobj.put("projectName", "kmk");
    	jobj.put("status", "completed");
    	jobj.put("teamSize", 18);
    	
        given()
        .contentType(ContentType.JSON)
        .body(jobj)
        
        .when()
        .put("http://localhost:8084/projects/TY_PROJ_603")
        
        .then()
        .assertThat()
        .statusCode(200)
        .log().all();
        
    	
    }
}
