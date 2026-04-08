package customKeywords

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import java.time.Duration

class ButtonKeywords {
    def clickButtonByText(String buttonText, int timeout = 30) {
        WebDriver driver = DriverFactory.getWebDriver()
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout))

        // Strategi 1: elemen dengan direct text node exact match
        // Cocok untuk: <span>naya amanda</span> atau <div>naya amanda</div>
        String xpathDirect = "//*[text()[normalize-space(.)='${buttonText}']]"

        // Strategi 2: normalize-space seluruh elemen exact match
        // Cocok untuk elemen yang hanya berisi satu teks tanpa child lain
        String xpathFull = "//*[normalize-space(.)='${buttonText}']"

        // Strategi 3: contains — paling longgar, untuk row/card yang punya child extra
        // Cocok untuk: <li>NA naya amanda 1</li> yang mengandung 'naya amanda'
        String xpathContains = "//*[contains(., '${buttonText}') and not(.//*[contains(., '${buttonText}')])]"

        List<String> strategies = [xpathDirect, xpathFull, xpathContains]
        List<String> names = ["direct text node", "normalize-space exact", "contains deepest"]

        for (int i = 0; i < strategies.size(); i++) {
            try {
                List<WebElement> found = driver.findElements(By.xpath(strategies[i]))
                if (found.size() > 0) {
                    WebElement element = found[0]
                    KeywordUtil.logInfo("🔍 Strategi [${names[i]}] menemukan elemen: <${element.getTagName()}>")

                    ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});", element)
                    Thread.sleep(500)

                    try {
                        element.click()
                    } catch (Exception ex) {
                        KeywordUtil.logInfo("⚠️ Klik biasa gagal, pakai JS click...")
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element)
                    }

                    KeywordUtil.logInfo("✅ Berhasil klik elemen dengan text: '${buttonText}' [${names[i]}]")
                    return
                }
            } catch (Exception e) {
                KeywordUtil.logInfo("⚠️ Strategi [${names[i]}] gagal: ${e.getMessage()}")
            }
        }

        // Semua strategi gagal
        KeywordUtil.markFailed("❌ Tidak ada elemen ditemukan dengan text: '${buttonText}' setelah 3 strategi XPath.")
    }

    /**
     * Klik elemen yang mengandung sebagian teks (partial match).
     * @param partialText - sebagian teks yang ada di elemen
     * @param timeout     - waktu tunggu dalam detik (default: 30)
     */
    @Keyword
    def clickButtonContainingText(String partialText, int timeout = 30) {
        WebDriver driver = DriverFactory.getWebDriver()

        // Cari elemen terdalam yang mengandung teks (hindari parent yang juga match)
        String xpath = "//*[contains(normalize-space(.), '${partialText}') and not(.//*[contains(normalize-space(.), '${partialText}')])]"

        try {
            List<WebElement> found = driver.findElements(By.xpath(xpath))
            if (found.size() == 0) {
                // Fallback: semua elemen yang mengandung teks
                found = driver.findElements(By.xpath("//*[contains(., '${partialText}')]"))
            }

            if (found.size() == 0) {
                KeywordUtil.markFailed("❌ Tidak ada elemen mengandung text: '${partialText}'")
                return
            }

            WebElement element = found[0]
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element)
            Thread.sleep(500)

            try {
                element.click()
            } catch (Exception ex) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element)
            }

            KeywordUtil.logInfo("✅ Berhasil klik elemen mengandung text: '${partialText}'")
        } catch (Exception e) {
            KeywordUtil.markFailed("❌ Gagal klik elemen mengandung text: '${partialText}'. Error: ${e.getMessage()}")
        }
    }

    /**
     * Klik elemen exact text tanpa peduli huruf besar/kecil (case-insensitive).
     * @param buttonText - teks elemen
     * @param timeout    - waktu tunggu dalam detik (default: 30)
     */
    @Keyword
    def clickButtonByTextIgnoreCase(String buttonText, int timeout = 30) {
        WebDriver driver = DriverFactory.getWebDriver()

        String lowerText = buttonText.toLowerCase()
        String upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        String lower = 'abcdefghijklmnopqrstuvwxyz'

        // Cari via direct text node dulu (lebih presisi)
        String xpath = "//*[text()[translate(normalize-space(.), '${upper}', '${lower}')='${lowerText}']]"
        List<WebElement> found = driver.findElements(By.xpath(xpath))

        if (found.size() == 0) {
            // Fallback: normalize-space seluruh elemen
            xpath = "//*[translate(normalize-space(.), '${upper}', '${lower}')='${lowerText}']"
            found = driver.findElements(By.xpath(xpath))
        }

        if (found.size() == 0) {
            KeywordUtil.markFailed("❌ Tidak ada elemen dengan text (ignore case): '${buttonText}'")
            return
        }

        try {
            WebElement element = found[0]
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element)
            Thread.sleep(500)

            try {
                element.click()
            } catch (Exception ex) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element)
            }

            KeywordUtil.logInfo("✅ Berhasil klik elemen (ignore case): '${buttonText}'")
        } catch (Exception e) {
            KeywordUtil.markFailed("❌ Gagal klik elemen (ignore case): '${buttonText}'. Error: ${e.getMessage()}")
        }
    }

    /**
     * Verifikasi elemen dengan text tertentu tampil di halaman.
     * @param buttonText - teks elemen yang ingin diverifikasi
     * @param timeout    - waktu tunggu dalam detik (default: 30)
     */
    @Keyword
    def verifyButtonWithTextVisible(String buttonText, int timeout = 30) {
        WebDriver driver = DriverFactory.getWebDriver()
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout))

        String xpath = "//*[text()[normalize-space(.)='${buttonText}']]"

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)))
            KeywordUtil.logInfo("✅ Elemen dengan text '${buttonText}' terlihat di halaman")
        } catch (Exception e) {
            // Coba fallback
            try {
                String xpathFull = "//*[normalize-space(.)='${buttonText}']"
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFull)))
                KeywordUtil.logInfo("✅ Elemen dengan text '${buttonText}' terlihat di halaman")
            } catch (Exception e2) {
                KeywordUtil.markFailed("❌ Elemen dengan text '${buttonText}' tidak ditemukan. Error: ${e2.getMessage()}")
            }
        }
    }
}