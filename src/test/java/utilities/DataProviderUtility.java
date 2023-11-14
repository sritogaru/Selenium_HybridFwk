package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	@DataProvider(name="DataDriven")
	public String [][] getdata() throws IOException {
		
		String path = ".\\test-data\\DataDriven.xlsx";
		
		ExcelUtility XL = new ExcelUtility(path); // creating object for excelutility class
		
		int rowscount= XL.getRowCount(path, "LoginData"); //getting row count
		int colscount= XL.getColumnCount(path, "LoginData", 1); //getting column count
		
		String logindata[][]= new String [rowscount][colscount]; // creating 2-d array for rows&columns
		
		for(int i=1; i<=rowscount;i++) { // exclude header part so that's y start from row 1
			
			for(int j=0; j<colscount;j++) {
			
		logindata[i-1][j]= XL.getCellData(path,"LoginData", i, j);
// In 2D array index starts from 0 and in excel rows start from 1, inorder to match both -1 we r doing
				
				
			}
		}
		
		
		
		return logindata; //returning 2D array
		
	}

}
