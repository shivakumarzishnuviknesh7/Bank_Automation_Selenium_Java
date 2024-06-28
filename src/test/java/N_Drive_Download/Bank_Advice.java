package N_Drive_Download;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import custom_utilities.base.Browser_Launch;
import custom_utilities.base.Download_utility;
import custom_utilities.base.Excel_Utility;
import custom_utilities.pages_N_drive.N_Drive_Download_Login;
import custom_utilities.pages_N_drive.N_Drive_page;
import custom_utilities.pages_N_drive.Neosuite_Home_Page;

public class Bank_Advice   extends Browser_Launch  {
	
	@Test
	public void tc8_Download_File_Bank_Advice() throws IOException, InterruptedException, AWTException {

		N_Drive_page N_Drive_page_calls = new N_Drive_page(driver);
		Neosuite_Home_Page Neosuite_Home_Page_calls = new Neosuite_Home_Page(driver);
		N_Drive_Download_Login N_Drive_Download_Login_calls = new N_Drive_Download_Login(driver);
		Download_utility Download_utility_calls = new Download_utility(driver);
		
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		String sheet = "NDrive";
		String test_case_number = methodName;

		Excel_Utility datas = new Excel_Utility();
		ArrayList data = datas.getData(test_case_number, sheet);

		String Application_Name = (String) data.get(1);
		String Toaster_Message_one = (String) data.get(2);
		String Widget_Name = (String) data.get(3);
		String Client = (String) data.get(4);
		String Country = (String) data.get(5);
		String Legal_Entity = (String) data.get(6);
		String Application = (String) data.get(7);
		String Category_one = (String) data.get(8);
		String Category_two = (String) data.get(9);
		String Category_three = (String) data.get(10);

		String Category_four = (String) data.get(11);
		String Category_five = (String) data.get(12);
		String processing_year = (String) data.get(13);
		String processing_Period = (String) data.get(14);

		String Download_File_name = (String) data.get(15);
		String Folder_name = (String) data.get(16);
		String File_Rename = (String) data.get(17);
		String file_extension = (String) data.get(18);

		

		/*
		 * 
		 * TestCase Type - Positive 
		 * Expected Output - Able to download the generated Bank advice based on Bank file configured
		 *
		 */
		
		
		// login by using the id and password
		N_Drive_Download_Login_calls.N_Drive_Login(Toaster_Message_one);
		
		
		
		// bank module widget clicking
		Neosuite_Home_Page_calls.NDrive_click(Application_Name);

		// selecting SPOC N-Drive form
		N_Drive_page_calls.Form_Selection(Widget_Name);

		// selecting SPOC N-Drive form
		N_Drive_page_calls.Form_Selection_Check(Widget_Name);

		// selecting the plus button in SPOC N-Drive form
		N_Drive_page_calls.Apply_Filter_Clicking_Plus_Button();
		
		
		// clicking reset button
		N_Drive_page_calls.Reset_Button_Click();
		
		//checking all fields empty or not
		N_Drive_page_calls.Reset_Working_Check();

		// selecting client in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Client_Drop_Down(Client);

		// selecting country in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Country_Drop_Down(Country);

		// selecting legal entity in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Legal_Entity_Drop_Down(Legal_Entity);

		// selecting application in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Application_Drop_Down(Application);

		// selecting Category_one in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Category_One_Drop_Down(Category_one);

		// selecting Category_two in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Category_Two_Drop_Down(Category_two);


		// selecting Category_three in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Category_Three_Drop_Down(Category_three);
		
		// selecting Category_four  in SPOC N-Drive form
		N_Drive_page_calls.Clicking_Category_four_Drop_Down(Category_four);

		// clicking search button
		N_Drive_page_calls.Clicking_Search_Button();

		// clicking search button
		N_Drive_page_calls.Uploaded_On_Drop_Down_Click();

		// clicking search button
		N_Drive_page_calls.Sort_By_Newest_First_Click();
		
		//Check time and date
		N_Drive_page_calls.Date_Time_Check();

		// clicking download button
		N_Drive_page_calls.Download_Button_Click();

		// Download file checking
		Download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

	}


}
