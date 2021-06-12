package at.porscheinformatik.sonarqube.licensecheck.maven;

import static org.junit.Assert.assertNull;

import java.nio.file.Paths;

import org.junit.Test;

public class SettingsXmlParserTest {
    @Test
    public void testParseXmlFile() {
        // Arrange, Act and Assert
        assertNull(SettingsXmlParser.parseXmlFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertNull(
            SettingsXmlParser.parseXmlFile(Paths.get(System.getProperty("Could not find file "), "test.txt").toFile()));
    }

    @Test
    public void testParseXmlFile2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        SettingsXmlParser.parseXmlFile(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());
    }
}

