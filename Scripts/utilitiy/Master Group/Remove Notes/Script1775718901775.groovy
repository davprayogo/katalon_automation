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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://lumina-dev.satnusa.com/select-server')

WebUI.click(findTestObject('Object Repository/span_Login Again'))

WebUI.click(findTestObject('Page_lumina_web/button_login_with_sso'))

WebUI.setText(findTestObject('Object Repository/input_Username or email_username'), '030690')

WebUI.setEncryptedText(findTestObject('Object Repository/input_Password_password'), 'tzH6RvlfSTg=')

WebUI.click(findTestObject('Object Repository/button_Sign In'))

WebUI.click(findTestObject('button_Sign In and End Other Session'))

WebUI.click(findTestObject('Page_Select Server  Lumina/button_server_dev1'))

WebUI.click(findTestObject('Object Repository/span_Continue'))

WebUI.click(findTestObject('Page_Select Server  Lumina/button_server_dev1'))

WebUI.click(findTestObject('Object Repository/span_Continue'))

WebUI.click(findTestObject('Object Repository/a_keyframes spin             to  transform _3fdae5'))

WebUI.click(findTestObject('General/button_burger_list_menu'))

WebUI.click(findTestObject('Object Repository/button_Master Data          keyframes spin _ebbf0f'))

WebUI.click(findTestObject('Object Repository/a_Master Groups'))

WebUI.click(findTestObject('Object Repository/div_Intern'))

WebUI.click(findTestObject('Object Repository/button_keyframes spin             to  trans_c607ad'))

WebUI.click(findTestObject('Object Repository/div_Notes'))

WebUI.setText(findTestObject('Object Repository/textarea_Notes_textarea-_r_12_-input'), '')

WebUI.click(findTestObject('General/button_Save'))

WebUI.click(findTestObject('General/Button_Save_Confirm_Dialog'))

