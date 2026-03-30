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
import org.openqa.selenium.By

import internal.GlobalVariable

public class DatePickerHelper {
	@Keyword
	def selectDate1(String date) {

		Date d = Date.parse("yyyy-MM-dd", date)

		String label = d.format("EEE MMM dd yyyy")

		String xpath = "//td[@aria-label='" + label + "']//button"

		TestObject dateObj = new TestObject()
		dateObj.addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.waitForElementClickable(dateObj, 10)
		WebUI.click(dateObj)

		WebUI.comment("Selected date : " + label)
	}
	
	// =============================
	// SELECT SINGLE DATE
	// =============================
	@Keyword
	def selectDate(TestObject input, String date) {

		WebUI.click(input)

		Date target = Date.parse("yyyy-MM-dd", date)

		String targetMonth = target.format("MMMM")
		String targetYear = target.format("yyyy")

		navigateToMonthYear(targetMonth, targetYear)

		selectDay(target)
	}
	
	@Keyword
	def selectDay(Date date) {
		
		String label = date.format("EEE MMM dd yyyy")
		
		TestObject dayObj = new TestObject().addProperty(
			"xpath",
			ConditionType.EQUALS,
			"//td[@aria-label='${label}']//button"
		)
		
		WebUI.waitForElementClickable(dayObj, 10)
		
		WebUI.click(dayObj)
		
		WebUI.comment("Selected date: " + label)
	}
	
	// =============================
	// NAVIGATE MONTH YEAR
	// =============================
	def navigateToMonthYear(String month, String year) {

		TestObject monthObj = new TestObject().addProperty(
			"xpath",
			ConditionType.EQUALS,
			"//button[@aria-label='Select month: ${month}']"
		)

		TestObject yearObj = new TestObject().addProperty(
			"xpath",
			ConditionType.EQUALS,
			"//button[@aria-label='Select year: ${year}']"
		)

		int safety = 24

		while (safety > 0) {

			boolean correctMonth = WebUI.verifyElementPresent(monthObj, 1, FailureHandling.OPTIONAL)
			boolean correctYear = WebUI.verifyElementPresent(yearObj, 1, FailureHandling.OPTIONAL)

			if (correctMonth && correctYear) {
				break
			}

			TestObject nextMonth = new TestObject().addProperty(
				"xpath",
				ConditionType.EQUALS,
				"//button[@aria-label='Next month']"
			)

			WebUI.click(nextMonth)

			safety--
		}
	}

	// =============================
	// SELECT RANGE DATE
	// =============================
	@Keyword
	def selectDateRange(TestObject input, String startDate, String endDate) {

		WebUI.click(input)

		Date start = Date.parse("yyyy-MM-dd", startDate)
		Date end = Date.parse("yyyy-MM-dd", endDate)

		String startMonth = start.format("MMMM")
		String startYear = start.format("yyyy")

		navigateToMonthYear(startMonth, startYear)

		selectDay(start)

		String endMonth = end.format("MMMM")
		String endYear = end.format("yyyy")

		navigateToMonthYear(endMonth, endYear)

		selectDay(end)
	}
}
