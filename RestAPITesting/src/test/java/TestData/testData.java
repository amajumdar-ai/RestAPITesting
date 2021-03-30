package TestData;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class testData {
	
	@DataProvider(name="POSTExample1")
	
	public Object[][] dataforPst(){
		Object [][] data= new Object[1][2];
		data[0][0]="Arpita";
		data[0][1]="majumdar";
		return data ;
	}

	
	@DataProvider(name="POSTExample2")
	public Object[][] dataforPOST2()
	{
		return new Object[][] {
			{"APP","NEW"},
			{"ABC","12"},
			{"Iam","Arpita"},
			{"abc","xyz"},
			{"do","nothing"}
			
					
					
			
		};
	}
}
