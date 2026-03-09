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

CustomKeywords.'utility.Login.loginWithSSO_withGlobalVariable'()

WebUI.click(findTestObject('Page_Select Server  Lumina/button_server_dev2'))

WebUI.click(findTestObject('Page_Select Server  Lumina/button_ContinueOrSubmitServer'))

WebUI.click(findTestObject('Page_Home  Lumina/button_module_utility (1)'))

WebUI.click(findTestObject('Page_Master Groups  Lumina/button_create_new_group'))

WebUI.setText(findTestObject('Page_Master Groups  Lumina/input_field_group_name'), 'QC Staf')

WebUI.setText(findTestObject('Page_Master Groups  Lumina/select_field_module'), 'Utility')

'by defaul share group nya true jadi kalau mau tidak share tambahkan step ini '
WebUI.click(findTestObject('Page_Master Groups  Lumina/toggle_share_group'))

'by default statunya aktif jadi kalau mau tidak aktif groupnya tambahkan step ini '
WebUI.click(findTestObject('Page_Master Groups  Lumina/toggle_group_status'))

WebUI.click(findTestObject('Page_Master Groups  Lumina/button_tab_Inherited Groups'))

WebUI.click(findTestObject('Page_Master Groups  Lumina/button_tab_Access Right'))

WebUI.click(findTestObject('Page_Master Groups  Lumina/button_tab_Record Rules'))

WebUI.click(findTestObject('Page_Master Groups  Lumina/button_tab_Notes'))

WebUI.click(findTestObject('Page_Master Groups  Lumina/button_tab_User'))

