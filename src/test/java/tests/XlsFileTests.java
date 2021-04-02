package tests;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.*;

public class XlsFileTests {
    @Test
    void xlsTest() throws IOException {
        String xlsFilePath = "./src/test/resources/1.xls";
        String expectedData = "В2";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(1).getCell(1).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxTest() throws IOException {
        String xlsxFilePath = "./src/test/resources/1.xlsx";
        String expectedData = "С3";

        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}