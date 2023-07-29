package GenericUtilities;

import io.restassured.response.Response;
 /**
  * Consist the methods of restassured
  * @author mohit
  *
  */
public class RestAssuredLibrary {
/**
 * This method will return json data from the corresponding response body
 * @param response
 * @param path
 * @return
 */
	
	public String getJsonData(Response response, String path) {
	String jsonData=response.jsonPath().get(path);
	return jsonData;
	}
}
