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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


TestData excel = findTestData('Data Files/Perdin/Pengajuan')

//batas pilih menu
WebUI.click(findTestObject('Object Repository/Page_Dashboard New Mysystem/img'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard New Mysystem/a_Pengajuan'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard New Mysystem/Dinas_main_lbadd'))


WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/Tipe Pengajuan'))

if (excel.getValue('Tipe Pengajuan', 1) == 'Cash Advance') {
	WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/Cash Advance'))

} else {
	WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/Reimburse'))
}

WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/Department'));
String departmentValue = excel.getValue('Department', 1);

if (departmentValue.equals('Sales & Marketing')) {
    WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/DepartemenOptions-Sales and Marketing'));
} else if (departmentValue.equals('IT Operations')) {
    WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/Department-IT Operation'));
} else {
    WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/Department-IT Risk Management'));
}

WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/button-save'))
//WebUI.click(findTestObject('Object Repository/Pengajuan Perjalanan Dinas/Cash Advance'))

//WebUI.scrollToElement(findTestObject('Object Repository/Page_Dashboard New Mysystem/upload'), 0)

//WebUI.delay(5)
//String userDir = RunConfiguration.getProjectDir() + GlobalVariable.pathfoto

//path = userDir.replace('/','\\');

//WebUI.uploadFile(findTestObject('Object Repository/Page_Dashboard New Mysystem/upload'), path)

