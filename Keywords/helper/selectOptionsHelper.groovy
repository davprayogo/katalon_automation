package helper

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
import com.kms.katalon.core.testobject.ConditionType


import internal.GlobalVariable

public class selectOptionsHelper {
	@Keyword
	def selectCustomDropdown(TestObject dropdown, String optionText) {
	
		WebUI.click(dropdown)
	
		String xpath = "//button[contains(@type,'button') and contains(.,'MES')]"
	
		TestObject optionObj = new TestObject()
		optionObj.addProperty("xpath",ConditionType.EQUALS, xpath		)
	
		WebUI.waitForElementVisible(optionObj, 5)
		WebUI.scrollToElement(optionObj, 3)
		WebUI.click(optionObj)
	
	}

	@Keyword
	def selectMultipleCustomDropdown(TestObject dropdown, List optionTexts, boolean shouldClose = true) {
		WebUI.click(dropdown)	
		optionTexts.each { text ->

			String xpath = "//button[@type='button' and contains(normalize-space(.),'${text}')]"

			TestObject option = new TestObject("dynamicOption_" + text)
			option.addProperty("xpath", ConditionType.EQUALS, xpath)

			WebUI.waitForElementVisible(option, 10)
			WebUI.scrollToElement(option, 3)
			WebUI.click(option)

			WebUI.delay(1)
		}

		if(shouldClose){
			closeDropdownByRoot()
		}
	}

	@Keyword
	def closeDropdownByRoot(){

	    TestObject root = new TestObject("root_container")
	    root.addProperty("xpath", ConditionType.EQUALS, "//div[@id='root']")
	
	    WebUI.waitForElementVisible(root, 5)
	    WebUI.click(root)
	
	    WebUI.comment("Dropdown closed by clicking root container")
	}
	
	@Keyword
	def closeDropdown(TestObject closeObject = null){
	
		TestObject target
	
		if(closeObject != null){
			target = closeObject
			WebUI.comment("Closing dropdown using provided object")
		}
		else {
			target = new TestObject("root_container")
			target.addProperty("xpath", ConditionType.EQUALS, "//div[@id='root']")
			WebUI.comment("Closing dropdown using default root")
		}
	
		WebUI.waitForElementVisible(target, 5)
		WebUI.click(target)
	}
	
	@Keyword
	def ClearSelectedOption(TestObject selectField) {
		WebUI.click(selectField)
		WebUI.click(findTestObject('Object Repository/General/button_X_Clear Sleect'))
		
	}
}
