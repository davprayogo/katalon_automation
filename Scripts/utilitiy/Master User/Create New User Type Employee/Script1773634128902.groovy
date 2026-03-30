import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'utility.Login.loginWithOperatorKey_withGlobalVariable'()

WebUI.click(findTestObject('Page_Select Server  Lumina/button_server_dev1'))

WebUI.click(findTestObject('Page_Select Server  Lumina/button_ContinueOrSubmitServer'))

WebUI.click(findTestObject('Page_Home  Lumina/button_module_utility (1)'))

WebUI.click(findTestObject('General/button_burger_list_menu'))

WebUI.click(findTestObject('General/Btn Menu/btn_menu_Master Users'))

WebUI.click(findTestObject('Page_Master Users  Lumina/butto_create_user'))

WebUI.setText(findTestObject('Page_Master Users  Lumina/input_field_badgeNo'), '201078')

WebUI.click(findTestObject('Page_Master Users  Lumina/button_Check Employee'))

WebUI.click(findTestObject('Page_Master Groups  Lumina/button_add_if_no_data'))

CustomKeywords.'helper.TableHelper.selectMultipleCheckboxByColumnWithPagination'('Server Name', ['dev1', 'dev2'])

WebUI.click(findTestObject('Page_Master Users  Lumina/button_Next'))

CustomKeywords.'helper.DatePickerHelper.selectDateRange'(findTestObject('Page_Master Users  Lumina/input__daterangepicker-effective'), 
    '2026-03-20', '2027-03-02')

WebUI.click(findTestObject('Page_Master Users  Lumina/p_Effective Date'))

WebUI.click(findTestObject('Page_Master Users  Lumina/button_Apply to all Server'))

