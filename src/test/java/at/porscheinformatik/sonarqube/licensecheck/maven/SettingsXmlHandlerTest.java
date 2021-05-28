package at.porscheinformatik.sonarqube.licensecheck.maven;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.xml.sax.SAXException;

public class SettingsXmlHandlerTest {
    @Test
    public void testStartDocument() throws SAXException {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        (new SettingsXmlHandler()).startDocument();
    }

    @Test
    public void testStartDocument2() throws SAXException {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        (new SettingsXmlHandler()).startDocument();
    }

    @Test
    public void testCharacters() throws SAXException {
        // Arrange
        SettingsXmlHandler settingsXmlHandler = new SettingsXmlHandler();

        // Act
        settingsXmlHandler.characters("AAAAAAAA".toCharArray(), 1, 3);

        // Assert that nothing has changed
        assertNull(settingsXmlHandler.getSetting());
    }

    @Test
    public void testCharacters2() throws SAXException {
        // Arrange
        SettingsXmlHandler settingsXmlHandler = new SettingsXmlHandler();

        // Act
        settingsXmlHandler.characters("AAAAAAAA".toCharArray(), 1, 3);

        // Assert that nothing has changed
        assertNull(settingsXmlHandler.getSetting());
    }

    @Test
    public void testGetSetting() {
        // Arrange, Act and Assert
        assertNull((new SettingsXmlHandler()).getSetting());
        assertNull((new SettingsXmlHandler()).getSetting());
    }
}

