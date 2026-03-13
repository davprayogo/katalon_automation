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

WebUI.click(findTestObject('General/Btn Menu/btn_menu_Master Record Rules'))

WebUI.click(findTestObject('Page_Record Rules  Lumina/button_create_record_rule'))

WebUI.setText(findTestObject('Page_Record Rules  Lumina/input_field_name_record_rule'), 'MES Record Rule')

CustomKeywords.'helper.selectOptionsHelper.selectMultipleCustomDropdown'(findTestObject('Page_Record Rules  Lumina/select_field_model_record_rule'), 
    ['Menu'], false)

WebUI.setText(findTestObject('Page_Record Rules  Lumina/input_field_rule_definition'), 'asdasd')

WebUI.click(findTestObject('General/button_Save'))

WebUI.click(findTestObject('Page_Master Servers  Lumina/button_confirm_save'))

WebUI.verifyElementVisible(findTestObject('Page_Record Rules  Lumina/Validation/div_The name already exists. Please use a different name'))

WebUI.verifyElementVisible(findTestObject('Page_Record Rules  Lumina/Validation/div_The rule definition is not a valid LINQ_3c5615'))

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()

