package at.porscheinformatik.sonarqube.licensecheck.maven;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.xml.sax.SAXException;

public class SettingsXmlHandlerTest {
    @Test
    public void testCharacters() throws SAXException {
        SettingsXmlHandler settingsXmlHandler = new SettingsXmlHandler();

        settingsXmlHandler.characters("AAAAAAAA".toCharArray(), 1, 3);

        assertNull(settingsXmlHandler.getSetting());
    }

    @Test
    public void testCharacters2() throws SAXException {
        SettingsXmlHandler settingsXmlHandler = new SettingsXmlHandler();

        settingsXmlHandler.characters("AAAAAAAA".toCharArray(), 1, 3);

        assertNull(settingsXmlHandler.getSetting());
    }

    @Test
    public void testGetSetting() {
        assertNull((new SettingsXmlHandler()).getSetting());
        assertNull((new SettingsXmlHandler()).getSetting());
    }
}

