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
        // Arrange and Act
        MavenLicenseService actualMavenLicenseService = new MavenLicenseService(new ConfigurationBridge(new MapSettings()));

        // Assert
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
        // Arrange, Act and Assert
        assertTrue((new MavenLicenseService(new ConfigurationBridge(new MapSettings()))).getMavenLicenseList().isEmpty());
    }

    @Test
    public void testGetMavenLicenseList2() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        // Act
        List<MavenLicense> actualMavenLicenseList = (new MavenLicenseService(new ConfigurationBridge(mapSettings)))
            .getMavenLicenseList();

        // Assert
        assertEquals(1, actualMavenLicenseList.size());
        assertNull(actualMavenLicenseList.get(0).getLicense());
    }

    @Test
    public void testGetMavenLicenseList3() {
        // Arrange
        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        // Act
        List<MavenLicense> actualMavenLicenseList = (new MavenLicenseService(new ConfigurationBridge(mapSettings)))
            .getMavenLicenseList();

        // Assert
        assertEquals(1, actualMavenLicenseList.size());
        assertNull(actualMavenLicenseList.get(0).getLicense());
    }

    @Test
    public void testGetMavenLicenseList4() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        // Act
        List<MavenLicense> actualMavenLicenseList = (new MavenLicenseService(new ConfigurationBridge(mapSettings)))
            .getMavenLicenseList();

        // Assert
        assertEquals(2, actualMavenLicenseList.size());
        assertNull(actualMavenLicenseList.get(1).getLicense());
        assertNull(actualMavenLicenseList.get(0).getLicense());
    }

    @Test
    public void testGetMavenLicenseListOld() {
        // Arrange, Act and Assert
        assertTrue(
            (new MavenLicenseService(new ConfigurationBridge(new MapSettings()))).getMavenLicenseListOld().isEmpty());
    }

//    @Test
//    public void testGetMavenLicenseListOld2() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings();
//        mapSettings.appendProperty("licensecheck.licensesregex", "42");
//
//        // Act
//        (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getMavenLicenseListOld();
//    }
//
//    @Test
//    public void testGetMavenLicenseListOld3() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
//        mapSettings.appendProperty("licensecheck.licensesregex", "42");
//
//        // Act
//        (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getMavenLicenseListOld();
//    }
//
//    @Test
//    public void testGetMavenLicenseListOld4() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings();
//        mapSettings.appendProperty("licensecheck.licensesregex", "[");
//
//        // Act
//        (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getMavenLicenseListOld();
//    }

    @Test
    public void testGetLicenseMap() {
        // Arrange, Act and Assert
        assertTrue((new MavenLicenseService(new ConfigurationBridge(new MapSettings()))).getLicenseMap().isEmpty());
    }

    @Test
    public void testGetLicenseMap2() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        // Act and Assert
        assertEquals(1, (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getLicenseMap().size());
    }

    @Test
    public void testGetLicenseMap3() {
        // Arrange
        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        // Act and Assert
        assertEquals(1, (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getLicenseMap().size());
    }

    @Test
    public void testGetLicenseMap4() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");

        // Act and Assert
        assertEquals(2, (new MavenLicenseService(new ConfigurationBridge(mapSettings))).getLicenseMap().size());
    }
}

