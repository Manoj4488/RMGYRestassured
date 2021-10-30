package Crudoperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Deleteoneproject {
@Test
public void delete() {
	Response res=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_407");
	res.then().assertThat().statusCode(204);
}
}
