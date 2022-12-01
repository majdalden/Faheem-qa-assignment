import io.appium.java_client.AppiumFluentWait
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.time.Duration

class FaheemAppTest {

    private var driver: AndroidDriver? = null

    @BeforeTest
    fun openAppInDevice() {
//        WebDriverManager.chromedriver().setup();
        val caps = DesiredCapabilities()
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator")
        //        caps.setCapability(MobileCapabilityType.APP, "/Volumes/MyFiles/MyProjects/MyJavaProjects/AppiumTest1/ParaibaTalk.apk");
        caps.setCapability(MobileCapabilityType.APP, File("app/FaheemApp.apk").absolutePath)
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        try {
            driver = AndroidDriver(URL("http://127.0.0.1:4723/wd/hub"), caps)
        } catch (e: MalformedURLException) {
            throw RuntimeException(e)
        }

        driver?.manage()?.timeouts()?.implicitlyWait(Duration.ofSeconds(5))
    }

    @Test(priority = 1)
    fun isLoginAsVisitorIsDisabled() {
//        val isLoginAsVisitorElements = driver?.findElements(By.className("android.widget.TextView"))
        /*val isLoginAsVisitorElements = WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")))

        val isLoginAsVisitorElement = if ((isLoginAsVisitorElements?.size ?: 0) > 0) {
            isLoginAsVisitorElements?.get(1)
        } else {
            null
        }*/

        val isLoginAsVisitorElement = WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='تصفح كزائر']")))


        Assert.assertTrue(isLoginAsVisitorElement?.isDisplayed ?: true)
    }

    @Test(priority = 2)
    fun isLoginAsVisitorTextIsCorrect() {
//        val isLoginAsVisitorElements = driver?.findElements(By.className("android.widget.TextView"))
        /*val isLoginAsVisitorElements = WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")))

        val isLoginAsVisitorElement = if ((isLoginAsVisitorElements?.size ?: 0) > 0) {
            isLoginAsVisitorElements?.get(1)
        } else {
            null
        }*/

        val isLoginAsVisitorElement = WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='تصفح كزائر']")))


        val isLoginAsVisitorElementText = isLoginAsVisitorElement?.text?.trim() ?: ""

        Assert.assertEquals(isLoginAsVisitorElementText, "تصفح كزائر")
    }

    @Test(priority = 3)
    fun isLoginAsVisitorIsClickable() {
//        val isLoginAsVisitorElements = driver?.findElements(By.className("android.widget.TextView"))
        /*val isLoginAsVisitorElements = WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")))

        val isLoginAsVisitorElement = if ((isLoginAsVisitorElements?.size ?: 0) > 0) {
            isLoginAsVisitorElements?.get(1)
        } else {
            null
        }*/

        val isLoginAsVisitorElement = WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='تصفح كزائر']")))


        isLoginAsVisitorElement?.click()

        val classThree = WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        ).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ثالث ابتدائي']")))


        Assert.assertTrue(classThree?.isDisplayed ?: true)

//        if (!driver?.windowHandles.isNullOrEmpty()){
//            driver?.windowHandles?.forEachIndexed { index, s ->
//                if (index > 0) {
//                    driver?.switchTo()?.window(s)
//                    driver?.close()
//                }
//            }
//            driver?.switchTo()?.window(driver?.windowHandles?.firstOrNull())
//        }
    }

    @AfterClass
    fun tearDown() {
        driver?.quit()
    }
}