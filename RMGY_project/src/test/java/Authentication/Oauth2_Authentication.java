package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_Authentication {
	@Test
	public void oauth()
	{
		//Generate the token
		Response res = given()
		.formParam("client_id", "SDET-RMG")
		.formParam("client_secret", "7eddc1f644e31c02725a63a544d3cce4")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		res.then().log().all();
		//capture the token
		String Token=res.jsonPath().get("access_token");
		System.out.println(Token);
		
		//create a new request to access the token
		given()
		.auth()
		.oauth2(Token)
		.pathParam("USER_ID", "2418")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();
		
		
		
		
		
	}

}
