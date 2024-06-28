package Bank_Module_Generation;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import custom_utilities.base.Browser_Launch;
import custom_utilities.base.Excel_Utility;
import custom_utilities.pages_Bank_Module.Bank_File_Generation;
import custom_utilities.pages_Bank_Module.Bank_Module_Login;
import custom_utilities.pages_Bank_Module.Generate_File;
import custom_utilities.pages_Bank_Module.Neosuite_Home_Page;

public class Pop_Up_Fail extends Browser_Launch {
	@Test
	public void tc8_pop_UP_Message_of_file_status_Fail() throws IOException, InterruptedException, AWTException {

		String sheet = "Bank_Module";
		String test_case_number = "tc8_pop_UP_Message_of_file_status_Fail";

		Excel_Utility datas = new Excel_Utility();
		ArrayList data = datas.getData(test_case_number, sheet);

		String Widget_Name = (String) data.get(1);
		String Country = (String) data.get(2);
		String Legal_Entity = (String) data.get(3);
		String Paygroup = (String) data.get(4);
		String processing_Period = (String) data.get(5);
		String PayRun_Type = (String) data.get(6);
		String Pay_Type = (String) data.get(7);
		String Toaster_Message_one = (String) data.get(8);
		String Toaster_Message_two = (String) data.get(9);
		String notification_message = (String) data.get(10);

		Bank_File_Generation Bank_File_Generation_calls = new Bank_File_Generation(driver);
		Generate_File Generate_File_calls = new Generate_File(driver);
		Bank_Module_Login Bank_Module_Login_calls = new Bank_Module_Login(driver);
		Neosuite_Home_Page Neosuite_Home_Page_calls = new Neosuite_Home_Page(driver);
		
		//login by using the id and password
        Bank_Module_Login_calls.bank_Login();
        
        //change role method
        Neosuite_Home_Page_calls.Click_on_AppRole_Icon();
        
        //bank module widget clicking 
        Neosuite_Home_Page_calls.Bank_Module_click(Widget_Name);

		/*
		 * 
		 * TestCase Type - Positive POP-UP Message of file status - Fail
		 * 
		 */

		// selecting the country
		Bank_File_Generation_calls.Country_Selection(Country);

		// selecting the legal entity
		Bank_File_Generation_calls.Legal_Entity(Legal_Entity);

		// selecting the pay group
		Bank_File_Generation_calls.PayGroup(Paygroup);

		// selecting processing period
		Bank_File_Generation_calls.Processing_Period(processing_Period);

		// selecting payrun type
		Bank_File_Generation_calls.PayRun_Type(PayRun_Type);

		// clicking the search button
		Bank_File_Generation_calls.Search_Button_Click();

		// clicking the generate file button
		Bank_File_Generation_calls.Generate_File_Button_Click();

		// checking the generate file page is visible or not
		Bank_File_Generation_calls.Generate_File_Visibility_Check();

		// clicking the generate bank file check box
		Generate_File_calls.Generate_Bank_File_Checkbox_click();

		// clicking the generate bank file check box
		Generate_File_calls.Check_Box_Selected_Generate_Bank_File_Check();

		// clicking the generate button
		Generate_File_calls.Generate_Button_Click();

		//Checking the toaster message
        Bank_File_Generation_calls.Assertion_Check(Toaster_Message_one);

		// wait until toaster is invisible
		Bank_File_Generation_calls.toaster_invisible();

		// bell icon clicking
		Bank_File_Generation_calls.Bell_Icon_Click();

		// Notification checking
		Bank_File_Generation_calls.Notification_Check(notification_message);

	}

}
