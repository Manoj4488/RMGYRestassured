package EndToEndRMGY;

import org.testng.Assert;
import org.testng.annotations.Test;

import Genericutilities.Baseapiclass;
import Genericutilities.Endpoint;
import Pojoclass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class CreateProject extends Baseapiclass{
	
	@Test
	public void createProjectAndVerifyInDB() throws Throwable
	{
        
		//create a project  API
		ProjectLibrary pLib = new ProjectLibrary("manoj", "hummer "+jLib.getRandomNumber(), "Created", 88);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post(Endpoint.addProject);
		
		res.then().log().all();
		
		//capture the expected data
		String expData = rLib.getJsonData(res, "projectName");
		System.out.println(expData);
		
		//verify it in database
		String query = "select * from project";
		String actData = dLib.executeQueryAndGetData(query, 4, expData);
		
		//validate
		Assert.assertEquals(actData, expData);
		System.out.println("sucessful");
		
		
	}

}
