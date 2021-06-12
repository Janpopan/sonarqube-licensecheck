package at.porscheinformatik.sonarqube.licensecheck.mavenlicense;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.junit.Test;
import org.sonar.api.config.PropertyDefinitions;
import org.sonar.api.config.internal.ConfigurationBridge;
import org.sonar.api.config.internal.MapSettings;
import org.sonar.api.utils.System2;

public class MavenLicenseServiceTest {
    @Test
    public void testConstructor() {
        MavenLicenseService actualMavenLicenseService = new MavenLicenseService(new ConfigurationBridge(new MapSettings()));

        Map<Pattern, String> licenseMap = actualMavenLicenseService.getLicenseMap();
        assertTrue(licenseMap instanceof java.util.HashMap);
        List<MavenLicense> mavenLicenseListOld = actualMavenLicenseService.getMavenLicenseListOld();
        assertTrue(mavenLicenseListOld instanceof ArrayList);
        assertTrue(licenseMap.isEmpty());
        assertTrue(mavenLicenseListOld.isEmpty());
        List<MavenLicense> mavenLicenseList = actualMavenLicenseService.getMavenLicenseList();
        assertTrue(mavenLicenseList instanceof ArrayList);
        assertEquals(mavenLicenseListOld, mavenLicenseList);
        assertTrue(mavenLicenseList.isEmpty());
    }

    @Test
    public void testGetMavenLicenseList() {
        assertTrue((new MavenLicenseService(new ConfigurationBridge(new MapSettings()))).getMavenLicenseList().isEmpty());
    }

    @Test
    public void testGetMavenLicenseList2() {
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        List<MavenLicense> actualMavenLicenseList = (new MavenLicenseService(new ConfigurationBridge(mapSettings)))
            .getMavenLicenseList();

        assertEquals(1, actualMavenLicenseList.size());
        assertNull(actualMavenLicenseList.get(0).getLicense());
    }

    @Test
    public void testGetMavenLicenseList3() {
        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        List<MavenLicense> actualMavenLicenseList = (new MavenLicenseService(new ConfigurationBridge(mapSettings)))
            .getMavenLicenseList();

        assertEquals(1, actualMavenLicenseList.size());
        assertNull(actualMavenLicenseList.get(0).getLicense());
    }

    @Test
    public void testGetMavenLicenseList4() {
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        List<MavenLicense> actualMavenLicenseList = (new MavenLicenseService(new ConfigurationBridge(mapSettings)))
            .getMavenLicenseList();

        assertEquals(2, actualMavenLicenseList.size());
        assertNull(actualMavenLicenseList.get(1).getLicense());
        assertNull(actualMavenLicenseList.get(0).getLicense());
    }

    @Test
    public void testGetMavenLicenseListOld() {
        assertTrue(
            (new MavenLicenseService(new ConfigurationBridge(new MapSettings()))).getMavenLicenseListOld().isEmpty());
    }


    @Test
    public void testGetLicenseMap() {
        assertTrue((new MavenLicenseService(new ConfigurationBridge(new MapSettings()))).getLicenseMap().isEmpty());
    }

    @Test
    public void testGetLicenseMap2() {
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        assertEquals(1, (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getLicenseMap().size());
    }

    @Test
    public void testGetLicenseMap3() {
        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        assertEquals(1, (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getLicenseMap().size());
    }

    @Test
    public void testGetLicenseMap4() {
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        assertEquals(2, (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getLicenseMap().size());
    }
}

