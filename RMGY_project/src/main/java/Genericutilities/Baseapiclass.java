package Genericutilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class Baseapiclass {
	
	public Databaseutility dLib = new Databaseutility();
	public Restssuredutility rLib = new Restssuredutility();
	public Javautility jLib = new Javautility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
       dLib.connectToDB();
       baseURI = "http://localhost";
       port = 8084;
      
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dLib.closeDB();
	}

}
