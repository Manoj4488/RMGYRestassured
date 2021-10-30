package Genericutilities;

import io.restassured.response.Response;

/**
 * this class contains generic methods pertaining to rest-assured
 * @author manoj
 *
 */
public class Restssuredutility {
	
	/**
	 * This method will return the data inside JSON path
	 * @param res
	 * @param jsonPath
	 * @return
	 */
	public String getJsonData(Response res, String jsonPath)
	{
		String value =res.jsonPath().get(jsonPath);
		return value;
	}

}
