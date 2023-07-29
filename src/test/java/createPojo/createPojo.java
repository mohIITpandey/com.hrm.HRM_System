package createPojo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import GenericUtilities.BaseClass;
import GenericUtilities.DataBaseUtility;
import GenericUtilities.EndpointsLibrary;
import GenericUtilities.JavaUtility;
import PojoClass.CreatePojo;
import static io.restassured.RestAssured.*;
import java.sql.SQLException;
import io.restassured.response.Response;

public class createPojo extends BaseClass{
JavaUtility jlib=new JavaUtility();
@Test
public void createPojoo() throws SQLException  {
	
	DataBaseUtility DbUtils=new DataBaseUtility();
	
	CreatePojo poj=new CreatePojo("mohit", "anything"+jlib.getRandomNum(),"createddd", 3);
	
	Response response=given().spec(reqB).body(poj)
			 .when().post(EndpointsLibrary.createProject);
	         String expData =resLib.getJsonData(response,"projectId");
	         System.out.println(expData);
	
	        String query="select * from project;";
	        String actData = DbUtils.readDataFromDBAndValidate(query, 1, expData);
	        System.out.println(actData+"---------");

	        AssertJUnit.assertEquals(expData,actData);
	        System.out.println("OK");
	        
	        
	        response.then().log().all();
	        
}
	
	
}
