package utils;

import org.testng.annotations.DataProvider;

public class DataDriven {
	@DataProvider(name="dataforpost")
	public Object[][] postdata(){
		return new Object[][]
				{
			{"cube","arpita",101},
			{"status","Chemestry",102},
			{"roll","gem",103}
				};
	}

}
