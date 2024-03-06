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

//Master Biaya
WebUI.click(findTestObject('Master Biaya/a_Master Biaya'))

WebUI.click(findTestObject('Master Biaya/a_Master Biayalbadd'))

//Jenis Perjalanan
WebUI.click(findTestObject('Master Biaya/JenisPerjalanan'))

if (masterbiaya.getValue('Jenis Perjalanan', 1) == 'Luar Kota') {
} else if (masterbiaya.getValue('Jenis Perjalanan', 1) == 'Dalam Negeri') {
    WebUI.click(findTestObject('Object Repository/Master Biaya/JenisPerjalanan-DalamNegeri'))
} else if (masterbiaya.getValue('Jenis Perjalanan', 1) == 'Luar Negeri') {
    WebUI.click(findTestObject('Object Repository/Master Biaya/JenisPerjalanan-LuarNegeri'))
} else {
    WebUI.click(findTestObject('Object Repository/Master Biaya/JenisPerjalanan-DalamKota'))
}

//Jenis Biaya
WebUI.click(findTestObject('Master Biaya/JenisBiaya'))

if (masterbiaya.getValue('Jenis Biaya', 1) == 'Transportasi') {
    WebUI.click(findTestObject('Object Repository/Master Biaya/Jenis Biaya-Transportasi'))

    WebUI.click(findTestObject('Object Repository/Master Biaya/BBM'))

    if (masterbiaya.getValue('BBM', 1) == '1500') {
        WebUI.click(findTestObject('Object Repository/Master Biaya/BBM-1500'))
    } else {
        WebUI.click(findTestObject('Object Repository/Master Biaya/BBM-1000'))
    }
    
    WebUI.click(findTestObject('Object Repository/Master Biaya/Pengganti'))

    if (masterbiaya.getValue('Pengganti', 1) == 'Iya') {
        WebUI.click(findTestObject('Object Repository/Master Biaya/Pengganti-Iya'))
    } else {
        WebUI.click(findTestObject('Object Repository/Master Biaya/Pengganti-Tidak'))
    }
} else if (masterbiaya.getValue('Jenis Biaya', 1) == 'Uang Makan') {
    WebUI.click(findTestObject('Object Repository/Master Biaya/Jenis Biaya-Uang Makan'))

    WebUI.click(findTestObject('Object Repository/Master Biaya/Uang Makan'))

    if (masterbiaya.getValue('Uang Makan', 1) == '100%') {
        WebUI.click(findTestObject('Object Repository/Master Biaya/Uang Makan-100'))
    } else if (masterbiaya.getValue('Uang Makan', 1) == '75%') {
        WebUI.click(findTestObject('Object Repository/Master Biaya/Uang Makan-75'))
    } else {
        WebUI.click(findTestObject('Object Repository/Master Biaya/Uang Makan-0'))
    }
} else {
    WebUI.click(findTestObject('Object Repository/Master Biaya/Jenis Biaya-Hotel'))

    WebUI.scrollToElement(findTestObject('Object Repository/Master Biaya/Status'), 0)

    WebUI.click(findTestObject('Object Repository/Master Biaya/Akomodasi_Hotelpermalam'))

    WebUI.setText(findTestObject('Object Repository/Master Biaya/input__select2-search__field'), '10000')

    WebUI.click(findTestObject('Object Repository/Master Biaya/li_1000000.00'))
}

if (masterbiaya.getValue('Jabatan', 1) == 'Semua Jabatan') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_JabatanGrade_semua'))
} else if (masterbiaya.getValue('Jabatan', 1) == 'General Manager') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/inputgm'))
} else if (masterbiaya.getValue('Jabatan', 1) == 'Senior Manager') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_srmgr'))
} else if (masterbiaya.getValue('Jabatan', 1) == 'Manager') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/inputmgr'))
	if(masterbiaya.getValue('Manager',1)== 'Grade C') {
		WebUI.click(findTestObject('Object Repository/Master Biaya/input_Grade_C'))
	}else if(masterbiaya.getValue('Manager',1)== 'Grade D') {
		WebUI.click(findTestObject('Object Repository/Master Biaya/input_Grade_D'))
	}else {
		WebUI.click(findTestObject('Object Repository/Master Biaya/input_Grade_E'))
	}
	WebUI.click(findTestObject('Object Repository/Master Biaya/inputmgr'))
} else if (masterbiaya.getValue('Jabatan', 1) == 'Supervisor') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_spv'))
} else if (masterbiaya.getValue('Jabatan', 1) == 'staff Officer') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_so'))
} else if (masterbiaya.getValue('Jabatan', 1) == 'Officer') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_ofc'))
} else if (masterbiaya.getValue('Jabatan', 1) == 'Staff') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_staff'))
} else {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_nonstaff'))
}

if(masterbiaya.getValue('Lama Perdin',1)== '< 16') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_Lama Perdin_16'))
}else if(masterbiaya.getValue('Lama Perdin',1)== '>= 12 <= 16'){
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_Lama Perdin_12_16'))
}else {
	WebUI.click(findTestObject('Object Repository/Master Biaya/input_Lama Perdin_12'))
}

WebUI.click(findTestObject('Object Repository/Master Biaya/Status'))
if(masterbiaya.getValue('Status', 1)== 'Tidak Aktif') {
	WebUI.click(findTestObject('Object Repository/Master Biaya/Status-Tidak Aktif'))
}else {
	WebUI.click(findTestObject('Object Repository/Master Biaya/Status'))
}


WebUI.scrollToElement(findTestObject('Object Repository/Master Biaya/Button Save Master Biaya'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Master Biaya/Button Save Master Biaya'))
