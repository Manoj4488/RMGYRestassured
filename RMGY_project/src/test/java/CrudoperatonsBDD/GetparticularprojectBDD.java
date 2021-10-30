package CrudoperatonsBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetparticularprojectBDD {
@Test
public void project() {
	when()
	.get("http://localhost:8084/projects/TY_PROJ_603")
	
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
}
}
