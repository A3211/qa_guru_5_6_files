package tests;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipFileTests {
    @Test
    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/1.zip";
        String unzipFolderPath = "./src/test/resources/unzip";
        String unzipTxtFilePath = "./src/test/resources/unzip/1.txt";
        String expectedData = "Hello";
        String zipPassword = "123456";

        unzip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
