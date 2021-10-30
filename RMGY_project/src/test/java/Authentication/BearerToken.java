package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken {
	
	@Test
	public void bearerToken()
	{
		//create the data
		HashMap map = new HashMap();
		map.put("name", "RMGY-RESTASSURED_bearertoken");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().all();
		
	}

}
