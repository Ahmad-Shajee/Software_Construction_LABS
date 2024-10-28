package lab07;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class FileSearchTest {
    private FileSearch fileSearch;

    @Before
    public void setUp() {
        fileSearch = new FileSearch();
    }

    @Test
    public void testFileFound() {
        // Provide the directory path and target file name
        String directoryPath = "C:\\Users\\Asfand Yar\\eclipse-workspace\\HelloWorld\\src";
        String targetFileName = "text1.txt";

        // Call the searchFile method
        fileSearch.searchFile(new File(directoryPath), targetFileName);

        // Assert that the file is found
        assertTrue(fileSearch.isFileFound());
    }

    @Test
    public void testFileNotFound() {
        // Provide the directory path and a non-existent target file name
        String directoryPath = "src/test/resources";
        String targetFileName = "nonExistentFile.txt";

        // Call the searchFile method
        fileSearch.searchFile(new File(directoryPath), targetFileName);

        // Assert that the file is not found
        assertFalse(fileSearch.isFileFound());
        assertNull(fileSearch.getFoundFile());
    }
}
