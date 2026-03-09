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
//import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.*
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.By

import internal.GlobalVariable

public class TableHelper {
	@Keyword
	def selectCheckboxByColumnValue(String columnName, String value) {
	
		String xpath = "//tr[td[normalize-space()='" + value + "']]//input[@type='checkbox']"
	
		TestObject obj = new TestObject()
		obj.addProperty("xpath", ConditionType.EQUALS, xpath)
	
		WebUI.verifyElementPresent(obj, 5)
		WebUI.click(obj)
	}
	
	@Keyword
	def selectCheckboxByNameWithPagination(String name) {

		boolean isFound = false
		int maxPageLoop = 50   // safety breaker supaya tidak infinite loop
		int currentLoop = 0

		while (!isFound && currentLoop < maxPageLoop) {

			currentLoop++

			String rowXpath = "//tr[td[normalize-space()='" + name + "']]"
			String checkboxXpath = rowXpath + "//input[@type='checkbox']"

			TestObject rowObject = new TestObject()
			rowObject.addProperty("xpath", ConditionType.EQUALS, rowXpath)

			boolean present = WebUI.verifyElementPresent(rowObject, 3, FailureHandling.OPTIONAL)

			if (present) {

				TestObject checkboxObject = new TestObject()
				checkboxObject.addProperty("xpath", ConditionType.EQUALS, checkboxXpath)

				WebUI.scrollToElement(checkboxObject, 3)
				WebUI.click(checkboxObject)

				isFound = true
				println("✅ Data ditemukan di page ke-" + currentLoop)
				break
			}

			// ---- Kalau tidak ada di page ini → cek tombol next ----

			TestObject nextButton = new TestObject()
			nextButton.addProperty("xpath", ConditionType.EQUALS,
				"//button[normalize-space()='Next' and not(@disabled)]")

			boolean hasNext = WebUI.verifyElementPresent(nextButton, 3, FailureHandling.OPTIONAL)

			if (hasNext) {
				WebUI.click(nextButton)
				WebUI.delay(1)  // tunggu table reload
			} else {
				break
			}
		}

		if (!isFound) {
			WebUI.comment("❌ Data tidak ditemukan di semua halaman")
			assert false : "Data dengan nama '${name}' tidak ditemukan di semua page"
		}
	}
	
	@Keyword
	def selectCheckboxByColumnAndValueWithPagination(String columnName, String value) {

		boolean isFound = false
		int maxLoop = 50
		int currentLoop = 0

		while (!isFound && currentLoop < maxLoop) {

			currentLoop++
			println("🔎 Checking page ke-" + currentLoop)

			// 1️⃣ Cari index column berdasarkan header
			String headerXpath = "//th[normalize-space()='" + columnName + "']"
			TestObject headerObj = new TestObject()
			headerObj.addProperty("xpath", ConditionType.EQUALS, headerXpath)

			WebUI.verifyElementPresent(headerObj, 5)

			int columnIndex = WebUI.findWebElements(headerObj, 5)
				.get(0)
				.findElements(org.openqa.selenium.By.xpath("preceding-sibling::th"))
				.size() + 1

			println("📌 Column index ditemukan: " + columnIndex)

			// 2️⃣ Cari row berdasarkan column index
			String rowXpath = "//tr[td[" + columnIndex + "][contains(normalize-space(),'" + value + "')]]"
			String checkboxXpath = rowXpath + "//input[@type='checkbox']"

			TestObject rowObj = new TestObject()
			rowObj.addProperty("xpath", ConditionType.EQUALS, rowXpath)

			boolean present = WebUI.verifyElementPresent(rowObj, 3, FailureHandling.OPTIONAL)

			if (present) {

				TestObject checkboxObj = new TestObject()
				checkboxObj.addProperty("xpath", ConditionType.EQUALS, checkboxXpath)

				WebUI.scrollToElement(checkboxObj, 3)
				WebUI.click(checkboxObj)

				println("✅ Data ditemukan & checkbox diklik")
				isFound = true
				break
			}

			// 3️⃣ Cek tombol next
			TestObject nextBtn = new TestObject()
			nextBtn.addProperty("xpath", ConditionType.EQUALS,
				"//button[not(@disabled) and (contains(.,'Next') or @aria-label='Next page')]"
			)

			boolean hasNext = WebUI.verifyElementPresent(nextBtn, 3, FailureHandling.OPTIONAL)

			if (hasNext) {
				WebUI.click(nextBtn)
				WebUI.delay(1)
			} else {
				break
			}
		}

		if (!isFound) {
			assert false : "❌ Data dengan value '${value}' pada column '${columnName}' tidak ditemukan."
		}
	}
	
	@Keyword
	def selectMultipleCheckboxByColumnWithPagination(String columnName, List<String> values) {

		int maxLoop = 50
		int currentLoop = 0

		// Track value yang sudah ketemu
		Set<String> foundValues = []

		while (currentLoop < maxLoop) {

			currentLoop++
			println("🔎 Checking page ke-" + currentLoop)

			// 1️⃣ Cari column index
			String headerXpath = "//th[normalize-space()='" + columnName + "']"
			TestObject headerObj = new TestObject()
			headerObj.addProperty("xpath", ConditionType.EQUALS, headerXpath)

			WebUI.verifyElementPresent(headerObj, 5)

			int columnIndex = WebUI.findWebElements(headerObj, 5)
				.get(0)
				.findElements(By.xpath("preceding-sibling::th"))
				.size() + 1

			// 2️⃣ Loop setiap value
			values.each { value ->

				String rowXpath = "//tr[td[" + columnIndex + "][normalize-space()='" + value + "']]"
				String checkboxXpath = rowXpath + "//input[@type='checkbox']"

				TestObject checkboxObj = new TestObject()
				checkboxObj.addProperty("xpath", ConditionType.EQUALS, checkboxXpath)

				List elements = WebUI.findWebElements(checkboxObj, 2)

				if (!elements.isEmpty()) {

					elements.each { el ->
						WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(el))
						WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
					}

					println("✅ Found & selected value: " + value)
					foundValues.add(value)
				}
			}

			// 3️⃣ Cek apakah semua value sudah ketemu
			if (foundValues.containsAll(values)) {
				println("🎉 Semua value sudah ditemukan")
				break
			}

			// 4️⃣ Cek next button
			TestObject nextBtn = new TestObject()
			nextBtn.addProperty("xpath", ConditionType.EQUALS,
				"//button[not(@disabled) and (contains(.,'Next') or @aria-label='Next page')]"
			)

			boolean hasNext = WebUI.verifyElementPresent(nextBtn, 3, FailureHandling.OPTIONAL)

			if (hasNext) {
				WebUI.click(nextBtn)
				WebUI.delay(1)
			} else {
				break
			}
		}

		// Final validation
		if (!foundValues.containsAll(values)) {
			assert false : "❌ Tidak semua value ditemukan. Missing: " +
				(values - foundValues)
		}
	}
}
