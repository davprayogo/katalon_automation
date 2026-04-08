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

WebUI.click(findTestObject('Page_lumina_web/button_Sign In and End Other Session'))

WebUI.click(findTestObject('Page_Select Server  Lumina/button_server_dev1'))

WebUI.click(findTestObject('Object Repository/span_Continue'))

WebUI.click(findTestObject('Page_Select Server  Lumina/button_server_dev1'))

WebUI.click(findTestObject('Object Repository/span_Continue'))

WebUI.click(findTestObject('Object Repository/a_keyframes spin             to  transform _3fdae5'))

WebUI.click(findTestObject('General/button_burger_list_menu'))

WebUI.click(findTestObject('Object Repository/button_Master Data          keyframes spin _ebbf0f'))

WebUI.click(findTestObject('Object Repository/a_Master Groups'))

WebUI.click(findTestObject('General/Button_Add_Master_Group'))

WebUI.setText(findTestObject('Object Repository/input__textfield-name-input'), 'Add Multiple Record Rules (Test)')

WebUI.click(findTestObject('Object Repository/div_Record Rules'))

WebUI.click(findTestObject('Object Repository/span_keyframes spin             to  transfo_73a151'))

CustomKeywords.'helper.TableHelper.selectCheckboxByColumnValue'('Record Rule', 'dummy 11')

CustomKeywords.'helper.TableHelper.selectCheckboxByColumnValue'('Record Rule', 'dummy 13')

WebUI.click(findTestObject('Object Repository/span_Add'))

WebUI.click(findTestObject('Object Repository/button_Save'))

WebUI.click(findTestObject('Object Repository/span_Save'))

