package CrudoperatonsBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetallBDD {
	@Test
	public void project() {
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
