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

TestData masterbiaya = findTestData('Data Files/Perdin/Master Biaya')
for (int baris = 1; baris <= masterbiaya.getRowNumbers(); baris++)
	{
		if (masterbiaya.getValue('Use', baris) == 'Yes')
			{
	//Master Biaya
	WebUI.click(findTestObject('Master Biaya/a_Master Biaya'))
	WebUI.click(findTestObject('Master Biaya/a_Master Biayalbadd'))
	
	//Jenis Perjalanan
	WebUI.click(findTestObject('Master Biaya/JenisPerjalanan'))
	WebUI.click(findTestObject('Object Repository/Master Biaya/JenisPerjalanan-' + masterbiaya.getValue('Jenis Perjalanan', baris)))

	//Jenis Biaya
	WebUI.click(findTestObject('Master Biaya/JenisBiaya'))
	WebUI.click(findTestObject('Object Repository/Master Biaya/Jenis Biaya-' + masterbiaya.getValue('Jenis Biaya', baris)))
	
	if (masterbiaya.getValue('Jenis Biaya', baris) == 'Transportasi') 
		{
			WebUI.click(findTestObject('Object Repository/Master Biaya/BBM'))
			WebUI.click(findTestObject('Object Repository/Master Biaya/BBM-' + masterbiaya.getValue('BBM', baris)))
			
			WebUI.click(findTestObject('Object Repository/Master Biaya/Pengganti'))
			WebUI.click(findTestObject('Object Repository/Master Biaya/Pengganti-' + masterbiaya.getValue('Pengganti', baris)))
			}
			else if (masterbiaya.getValue('Jenis Biaya', 1) == 'Uang Makan') {
				WebUI.click(findTestObject('Object Repository/Master Biaya/Uang Makan'))
				WebUI.click(findTestObject('Object Repository/Master Biaya/Uang Makan-' + masterbiaya.getValue('Uang Makan', baris)))
				} else 
					{
						WebUI.click(findTestObject('Object Repository/Master Biaya/Jenis Biaya-Hotel'))
						WebUI.scrollToElement(findTestObject('Object Repository/Master Biaya/Status-Aktif'), 0)
						WebUI.click(findTestObject('Object Repository/Master Biaya/Akomodasi_Hotelpermalam'))
						WebUI.setText(findTestObject('Object Repository/Master Biaya/input__select2-search__field'), '10000')
						WebUI.click(findTestObject('Object Repository/Master Biaya/li_1000000.00'))
						}
	
	//Jabatan
	if (masterbiaya.getValue('Jabatan', baris) == 'Semua Jabatan')
		{
			WebUI.click(findTestObject('Object Repository/Master Biaya/input_JabatanGrade_semua'))
			}else
				{
					WebUI.click(findTestObject('Object Repository/Master Biaya/Jabatan/Jabatan ' + masterbiaya.getValue('Jabatan', baris)))
					if (masterbiaya.getValue('Jabatan', baris) == 'Manager')
						{
							WebUI.click(findTestObject('Object Repository/Master Biaya/input ' + masterbiaya.getValue('Manager', baris)))
							}
							}

		//Lama Perdin	
	if(masterbiaya.getValue('Lama Perdin',1)== '< 16') {
		WebUI.click(findTestObject('Object Repository/Master Biaya/input_Lama Perdin_16'))
		}
		else if(masterbiaya.getValue('Lama Perdin',1)== '>= 12 <= 16'){
			WebUI.click(findTestObject('Object Repository/Master Biaya/input_Lama Perdin_12_16'))
			}
			else{
				WebUI.click(findTestObject('Object Repository/Master Biaya/input_Lama Perdin_12'))
				}
	
	//Status
	WebUI.click(findTestObject('Object Repository/Master Biaya/Status-Aktif'))
	WebUI.click(findTestObject('Object Repository/Master Biaya/Status-' + masterbiaya.getValue('Status', baris)))

	
	
	WebUI.scrollToElement(findTestObject('Object Repository/Master Biaya/Button Save Master Biaya'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/Master Biaya/Button Save Master Biaya'))
	}
	}
