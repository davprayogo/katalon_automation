package utility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Login {
	@Keyword
	def static void loginWithSSO(String url, String badge, String password) {
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)
		WebUI.maximizeWindow()
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_lumina_web/button_login_with_sso'), GlobalVariable.waitPresentTimeout)
		
		WebUI.click(findTestObject('Object Repository/Page_lumina_web/button_login_with_sso'))
		WebUI.setText(findTestObject('Object Repository/Page_Sign in to uat/input_Username or email_username'), badge)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign in to uat/input_Password_password'), password)
		WebUI.click(findTestObject('Object Repository/Page_Sign in to uat/button_Sign In'))
		
		
		
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_lumina_web/modal_confirmation_active_session_detected'), 5, FailureHandling.OPTIONAL)) {
			WebUI.comment("Modal Conflic Login Show")
			WebUI.click(findTestObject('Object Repository/Page_lumina_web/button_Sign In and End Other Session'))
		} else {
			WebUI.comment("Modal Conflic Login not show")
		}
	}
	
	@Keyword
	def static void loginWithSSO_withGlobalVariable() {
		loginWithSSO(GlobalVariable.uat_lumina_url, GlobalVariable.badge, GlobalVariable.password)
	}
	
	@Keyword
	def static void loginWithOperatorLoginKey(String url, String operatorLoginKey) {
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)
		WebUI.maximizeWindow()
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_lumina_web/button_login_with_operator_login_key'), GlobalVariable.waitPresentTimeout)
		
		WebUI.click(findTestObject('Object Repository/Page_lumina_web/button_login_with_operator_login_key'))
		WebUI.click(findTestObject('Object Repository/Page_lumina_web/button_Enter QR Code number manually'))
		WebUI.setText(findTestObject('Object Repository/Page_lumina_web/input_QR Code Number loginKey'), operatorLoginKey)
		WebUI.click(findTestObject('Object Repository/Page_lumina_web/span_Login'))
		
	}
	
	@Keyword
	def static void loginWithOperatorKey_withGlobalVariable() {
		loginWithOperatorLoginKey(GlobalVariable.uat_lumina_url, GlobalVariable.operator_login_key)
	}
	
	
	@Keyword
	def static void logout() {
		WebUI.click(findTestObject('Object Repository/Page_Home  Lumina/img_All Modules_w-full h-full object-cover _51433c'))
		WebUI.click(findTestObject('Object Repository/Page_Home  Lumina/p_Log Out'))
		WebUI.click(findTestObject('Object Repository/Page_Home  Lumina/span_Log out'))
		WebUI.verifyElementVisible(findTestObject('Page_lumina_web/button_login_with_sso'))
	}
}
