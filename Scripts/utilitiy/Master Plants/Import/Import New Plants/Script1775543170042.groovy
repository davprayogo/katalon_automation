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

WebUI.openBrowser('')

WebUI.openBrowser('')

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.navigateToUrl('https://lumina-dev.satnusa.com/select-server')

WebUI.click(findTestObject('Object Repository/span_Login Again'))

WebUI.click(findTestObject('Object Repository/span_keyframes spin             to  transfo_73a151'))

WebUI.setText(findTestObject('Object Repository/input_Username or email_username'), '030690')

WebUI.setEncryptedText(findTestObject('Object Repository/input_Password_password'), 'tzH6RvlfSTg=')

WebUI.sendKeys(findTestObject('Object Repository/input_Password_password'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/span_Sign In and End Other Session'))

WebUI.click(findTestObject('Object Repository/button_keyframes spin             to  trans_c607ad'))

WebUI.click(findTestObject('Object Repository/span_Continue'))

WebUI.click(findTestObject('Object Repository/button_keyframes spin             to  trans_c607ad'))

WebUI.click(findTestObject('Object Repository/span_Continue'))

WebUI.click(findTestObject('Object Repository/div_keyframes spin             to  transfor_e0f2e8'))

WebUI.click(findTestObject('Object Repository/svg'))

WebUI.click(findTestObject('Object Repository/a_Master Plants'))

WebUI.click(findTestObject('Object Repository/button_Import'))

WebUI.click(findTestObject('Object Repository/span_Download Template'))

WebUI.click(findTestObject('Object Repository/button_Download Template_absolute top-0 rig_05ac23'))

WebUI.click(findTestObject('Object Repository/span_Import'))

WebUI.click(findTestObject('Object Repository/span_Start Import'))

WebUI.setText(findTestObject('Object Repository/input_Filter_textfield-_r_f_-input'), 'ax')

