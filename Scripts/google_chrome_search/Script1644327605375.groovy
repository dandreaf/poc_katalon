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

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.google.com/')

imagenExists = WebUI.waitForElementPresent(findTestObject('Page_Google/img_google_chrome'), 10)

if (imagenExists) {
    println('Se encuentra Imagen de Google Chrome')

    inputExists = WebUI.waitForElementPresent(findTestObject('Page_Google/input_google_search'), 10)

    if (inputExists) {
        println('Se encuentra Input de Google Chrome')

        WebUI.setText(findTestObject('Page_Google/input_google_search'), 'Katalon Studio')

        WebUI.sendKeys(findTestObject('Page_Google/input_google_search'), Keys.chord(Keys.ENTER))

        resultExists = WebUI.waitForElementPresent(findTestObject('Page_katalon studio - Buscar con Google/google_first_search_results'), 
            10)

        if (resultExists) {
            println('Se encuentra Resultados en Google Chrome')

            WebUI.delay(5)

            firstResult = WebUI.getText(findTestObject('Page_katalon studio - Buscar con Google/google_first_search_results'))

            WebUI.takeScreenshot()

            println('firstResult: ' + firstResult)

            firstResultDescripcion = WebUI.getText(findTestObject('Page_katalon studio - Buscar con Google/google_first_description_search_results'))

            println('firstResultDescripcion: ' + firstResultDescripcion)
        } else {
            println('No se encuentra Resultados en Google Chrome')
        }
    } else {
        println('No se encuentra Input de Google Chrome')
    }
} else {
    println('No se encuentra Imagen de Google Chrome')
}

WebUI.closeBrowser()

