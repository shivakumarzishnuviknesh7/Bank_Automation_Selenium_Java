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

public class bank_module_suite extends Browser_Launch {

    @Test(priority = 1)
    public void tc1_Login_Screen() throws AWTException, InterruptedException, IOException {
    	
        Bank_Module_Login Bank_Module_Login_calls = new Bank_Module_Login(driver);
        
        String sheet = "Bank_Module";
        String test_case_number = "tc1_Login_Screen";


        Excel_Utility datas = new Excel_Utility();
        ArrayList data = datas.getData(test_case_number, sheet);

        /*
         * 
         *    TestCase Type - Positive 
         *    Expected Output - User should be able to login
         *    
         */
        
        //login by using the id and password
        Bank_Module_Login_calls.bank_Login();

    }

    @Test(priority = 2, dependsOnMethods = {"tc1_Login_Screen"})
    public void tc2_Select_Bank_module_Widget() throws IOException, InterruptedException {

        String sheet = "Bank_Module";
        String test_case_number = "tc2_Select_Bank_module_Widget";


        Excel_Utility datas = new Excel_Utility();
        ArrayList data = datas.getData(test_case_number, sheet);

        String Widget_Name = (String) data.get(1);
        String Country = (String) data.get(2);
        String Legal_Entity = (String) data.get(3);
        String Paygroup = (String) data.get(4);
        String processing_Period = (String) data.get(5);
        String PayRun_Type = (String) data.get(6);
        String Pay_Type = (String) data.get(7);

        Neosuite_Home_Page Neosuite_Home_Page_calls = new Neosuite_Home_Page(driver);
        
        /*
         * 
         *    TestCase Type - Positive 
         *    Expected Output - User can able to view the Dashboard for selecting Country, BU, Pay group and Pay run details
         *    
         */
        

        //change role method
        Neosuite_Home_Page_calls.Click_on_AppRole_Icon();
        
        //bank module widget clicking 
        Neosuite_Home_Page_calls.Bank_Module_click(Widget_Name);

    }

    @Test(priority = 3, dependsOnMethods = "tc2_Select_Bank_module_Widget")
    public void tc3_Selecting_the_Required_details_of_CCBU_PG() throws IOException, InterruptedException {

        String sheet = "Bank_Module";
        String test_case_number = "tc3_Selecting_the_Required_details_of_CCBU_PG";


        Excel_Utility datas = new Excel_Utility();
        ArrayList data = datas.getData(test_case_number, sheet);

        String Widget_Name = (String) data.get(1);
        String Country = (String) data.get(2);
        String Legal_Entity = (String) data.get(3);
        String Paygroup = (String) data.get(4);
        String processing_Period = (String) data.get(5);
        String PayRun_Type = (String) data.get(6);
        String Pay_Type = (String) data.get(7);


        Bank_File_Generation Bank_File_Generation_calls = new Bank_File_Generation(driver);
        
        /*
         * 
         *    TestCase Type - Positive 
         *    Expected Output - After selected Country, BU, Pay group and Pay run details and clicked on SEARCH icon, user can able to see the Summary screen
         *    
         */

        //selecting the country
        Bank_File_Generation_calls.Country_Selection(Country);
        
        //selecting the legal entity
        Bank_File_Generation_calls.Legal_Entity(Legal_Entity);
        
        //selecting the pay group
        Bank_File_Generation_calls.PayGroup(Paygroup);
        
        //selecting processing period
        Bank_File_Generation_calls.Processing_Period(processing_Period);
        
        //selecting payrun type
        Bank_File_Generation_calls.PayRun_Type(PayRun_Type);
        
        //clicking the search button
        Bank_File_Generation_calls.Search_Button_Click();
        
        //checking the bank report is getting open 
        Bank_File_Generation_calls.Bank_Reports_visibility_check();

    }
    
    @Test(priority = 4, dependsOnMethods = "tc3_Selecting_the_Required_details_of_CCBU_PG")
    public void tc4_Clicking_the_generateICON() throws IOException {

        String sheet = "Bank_Module";
        String test_case_number = "tc4_Clicking_the_generateICON";


        Excel_Utility datas = new Excel_Utility();
        ArrayList data = datas.getData(test_case_number, sheet);

        String Widget_Name = (String) data.get(1);
        String Country = (String) data.get(2);
        String Legal_Entity = (String) data.get(3);
        String Paygroup = (String) data.get(4);
        String processing_Period = (String) data.get(5);
        String PayRun_Type = (String) data.get(6);
        String Pay_Type = (String) data.get(7);


        Bank_File_Generation Bank_File_Generation_calls = new Bank_File_Generation(driver);
        
        /*
         * 
         *    TestCase Type - Positive 
         *    Able to view the Generate dashborad screen to generate Bank file, Summary, Advice.
         *    
         */

        
        //clicking the generate file button 
        Bank_File_Generation_calls.Generate_File_Button_Click();
        
        //checking the generate file page is visible or not
        Bank_File_Generation_calls.Generate_File_Visibility_Check() ;

    }
    
    @Test(priority = 5, dependsOnMethods = "tc4_Clicking_the_generateICON")
    public void tc5_Tick_to_generate_the_bank_file() throws IOException, InterruptedException {

        String sheet = "Bank_Module";
        String test_case_number = "tc5_Tick_to_generate_the_bank_file";


        Excel_Utility datas = new Excel_Utility();
        ArrayList data = datas.getData(test_case_number, sheet);

        String Widget_Name = (String) data.get(1);
        String Country = (String) data.get(2);
        String Legal_Entity = (String) data.get(3);
        String Paygroup = (String) data.get(4);
        String processing_Period = (String) data.get(5);
        String PayRun_Type = (String) data.get(6);
        String Pay_Type = (String) data.get(7);

        Generate_File Generate_File_calls = new Generate_File(driver);
        
        /*
         * 
         *    TestCase Type - Positive 
         *    Able to select the tick icon which helps us to generate the Bank file
         *    
         */

        
         //clicking the generate bank file check box 
        Generate_File_calls.Generate_Bank_File_Checkbox_click();
        
         //clicking the generate bank file check box 
        Generate_File_calls.Check_Box_Selected_Generate_Bank_File_Check();              
       
    }
    
    @Test(priority = 6, dependsOnMethods = "tc5_Tick_to_generate_the_bank_file")
    public void tc6_Generate_the_bank_file() throws IOException, InterruptedException {

        String sheet = "Bank_Module";
        String test_case_number = "tc6_Generate_the_bank_file";


        Excel_Utility datas = new Excel_Utility();
        ArrayList data = datas.getData(test_case_number, sheet);

        String Widget_Name = (String) data.get(1);
        String Country = (String) data.get(2);
        String Legal_Entity = (String) data.get(3);
        String Paygroup = (String) data.get(4);
        String processing_Period = (String) data.get(5);
        String PayRun_Type = (String) data.get(6);
        String Pay_Type = (String) data.get(7);

        Generate_File Generate_File_calls = new Generate_File(driver);
        
        /*
         * 
         *    TestCase Type - Positive 
         *    To generate the bank file
         *    
         */
        
         //clicking the generate button
        Generate_File_calls.Generate_Button_Click();
        
    }
    
    @Test(priority = 7, dependsOnMethods = "tc6_Generate_the_bank_file")
    public void tc7_pop_UP_Message_of_file_status_Pass() throws IOException, InterruptedException {

        String sheet = "Bank_Module";
        String test_case_number = "tc7_pop_UP_Message_of_file_status_Pass";


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
        
        /*
         * 
         *    TestCase Type - Positive 
         *    POP-UP Message of file status - Pass
         *    
         */
        
         //Checking the toaster message
        Bank_File_Generation_calls.Assertion_Check(Toaster_Message_one);
        
        //wait until toaster is invisible
        Bank_File_Generation_calls.toaster_invisible();
        
        //bell icon clicking
        Bank_File_Generation_calls.Bell_Icon_Click();
        
        //Notification checking 
        Bank_File_Generation_calls.Notification_Check(notification_message);
        
    }
    
    @Test(priority = 8,dependsOnMethods = "tc3_Selecting_the_Required_details_of_CCBU_PG")
    public void tc9_Generate_The_Bank_Advice_And_Summary() throws IOException, InterruptedException {

        String sheet = "Bank_Module";
        String test_case_number = "tc9_Generate_The_Bank_Advice_And_Summary";


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
        

        Bank_File_Generation Bank_File_Generation_calls = new Bank_File_Generation(driver);
        Generate_File Generate_File_calls = new Generate_File(driver);
        
        /*
         * 
         *    TestCase Type - Positive 
         *    Generate the Bank advice and Summary 
         *    
         */
        
        //clicking the generate file button 
        Bank_File_Generation_calls.Generate_File_Button_Click();
        
        //clicking generate bank summary check box
        Generate_File_calls.Generate_Bank_Summary_Checkbox_click();
        
        //clicking generate bank Advice check box
        Generate_File_calls.Generate_Bank_Advice_Checkbox_click() ;
        
        //checking  generate bank summary check box is selected or not
        Generate_File_calls.Check_Box_Selected_Generate_Bank_Summary_Check(); 
        
        //checking  generate bank advice check box is selected or not
        Generate_File_calls.Check_Box_Selected_Generate_Bank_Advice_Check(); 
        
        //clicking the generate button
        Generate_File_calls.Generate_Button_Click();
        
    }
    
    @Test(priority = 9,dependsOnMethods = "tc9_Generate_The_Bank_Advice_And_Summary")
    public void tc10_Getting_pop_up_message() throws IOException, InterruptedException {

        String sheet = "Bank_Module";
        String test_case_number = "tc10_Getting_pop_up_message";


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
        String notification_message2 = (String) data.get(10);
        

        Bank_File_Generation Bank_File_Generation_calls = new Bank_File_Generation(driver);
        Generate_File Generate_File_calls = new Generate_File(driver);
        
        /*
         * 
         *    TestCase Type - Positive 
         *    Generate the Bank advice and Summary 
         *    
         */
        
         //Checking the toaster message
        Bank_File_Generation_calls.Assertion_Check(Toaster_Message_one);

        //wait until toaster disappear
        Bank_File_Generation_calls.toaster_invisible();
        
        //bell icon clicking
        Bank_File_Generation_calls.Bell_Icon_Click();
        
        // Notification checking 
        Bank_File_Generation_calls.Notification_Check_2_messages(notification_message,notification_message2);
        
    }
    
     
}
