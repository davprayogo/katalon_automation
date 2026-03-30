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

//CustomKeywords.'utility.Login.loginWithOperatorKey_withGlobalVariable'()
//
//WebUI.click(findTestObject('Page_Select Server  Lumina/button_server_dev1'))
//
//WebUI.click(findTestObject('Page_Select Server  Lumina/button_ContinueOrSubmitServer'))
//
//WebUI.click(findTestObject('Page_Home  Lumina/button_module_utility (1)'))
//
//WebUI.click(findTestObject('General/button_burger_list_menu'))
WebUI.click(findTestObject('General/Btn Menu/btn_menu_Master Servers'))

WebUI.click(findTestObject('Page_Master Servers  Lumina/button_create_server'))

WebUI.setText(findTestObject('Page_Master Servers  Lumina/input_field_name_server'), 'ASUS')

WebUI.setText(findTestObject('Page_Master Servers  Lumina/input_field_endpoint'), 'https://www.asus.com/id/')

WebUI.setText(findTestObject('Page_Master Servers  Lumina/textarea_field_remarks'), '-')

CustomKeywords.'helper.selectOptionsHelper.selectMultipleCustomDropdown'(findTestObject('Page_Master Servers  Lumina/select_field_plant'), 
    ['XM22'], true)

CustomKeywords.'helper.selectOptionsHelper.selectMultipleCustomDropdown'(findTestObject('Page_Master Servers  Lumina/select_field_businessPartner'), 
    ['XIAOMI'], true)

WebUI.click(findTestObject('Page_Master Servers  Lumina/button_Save_server'))

WebUI.waitForElementVisible(findTestObject('Page_Master Servers  Lumina/modal_confirmation_create_master_server'), 3)

WebUI.click(findTestObject('Page_Master Servers  Lumina/button_confirm_save'))

WebUI.verifyElementVisible(findTestObject('Page_Master Servers  Lumina/Validation/div_The name already exists. Please use a different name'))

WebUI.verifyElementVisible(findTestObject('Page_Master Servers  Lumina/Validation/div_The plant has been set in other server._fb04ce'))

WebUI.verifyElementVisible(findTestObject('Page_Master Servers  Lumina/Validation/div_Selected BP has been set in other serve_d6d6c3'))

WebUI.verifyElementVisible(findTestObject('Page_Master Servers  Lumina/Validation/div_The end point has been set in other ser_04d64c'))

WebUI.takeFullPageScreenshot()

