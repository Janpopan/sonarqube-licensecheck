package at.porscheinformatik.sonarqube.licensecheck.license;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense;
import at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicenseService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sonar.api.config.internal.ConfigurationBridge;
import org.sonar.api.config.internal.MapSettings;

public class LicenseServiceTest {
    @Test
    public void testConstructor() {
        // Arrange
        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());
        ProjectLicenseService projectLicenseService = new ProjectLicenseService(new ConfigurationBridge(new MapSettings()));

        // Act
        LicenseService actualLicenseService = new LicenseService(configuration, projectLicenseService);

        // Assert
        List<License> licenses = actualLicenseService.getLicenses();
        assertTrue(licenses instanceof ArrayList);
        List<License> licensesOld = actualLicenseService.getLicensesOld();
        assertTrue(licensesOld instanceof ArrayList);
        assertTrue(licenses.isEmpty());
        assertEquals(licenses, licensesOld);
        assertTrue(licensesOld.isEmpty());
        List<ProjectLicense> projectLicenseList = projectLicenseService.getProjectLicenseList();
        assertTrue(projectLicenseList instanceof ArrayList);
        List<ProjectLicense> projectLicenseListOld = projectLicenseService.getProjectLicenseListOld();
        assertTrue(projectLicenseListOld instanceof ArrayList);
        assertEquals(licensesOld, projectLicenseList);
        assertEquals(licenses, projectLicenseList);
        assertTrue(projectLicenseList.isEmpty());
        assertEquals(projectLicenseList, projectLicenseListOld);
        assertEquals(licensesOld, projectLicenseListOld);
        assertEquals(licenses, projectLicenseListOld);
        assertTrue(projectLicenseListOld.isEmpty());
    }

    @Test
    public void testGetLicenses() {
        // Arrange
        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());

        // Act and Assert
        assertTrue(
            (new LicenseService(configuration, new ProjectLicenseService(new ConfigurationBridge(new MapSettings()))))
                .getLicenses()
                .isEmpty());
    }

    @Test
    public void testGetLicenses2() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.license-set", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);

        // Act
        List<License> actualLicenses = (new LicenseService(configuration,
            new ProjectLicenseService(new ConfigurationBridge(new MapSettings())))).getLicenses();

        // Assert
        assertEquals(1, actualLicenses.size());
        License getResult = actualLicenses.get(0);
        assertFalse(getResult.getAllowed());
        assertNull(getResult.getName());
        assertNull(getResult.getIdentifier());
    }

    @Test
    public void testGetLicenses3() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.license-set", "42");
        mapSettings.appendProperty("licensecheck.license-set", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);

        // Act
        List<License> actualLicenses = (new LicenseService(configuration,
            new ProjectLicenseService(new ConfigurationBridge(new MapSettings())))).getLicenses();

        // Assert
        assertEquals(2, actualLicenses.size());
        License getResult = actualLicenses.get(1);
        assertNull(getResult.getName());
        assertNull(getResult.getIdentifier());
        assertFalse(getResult.getAllowed());
        License getResult1 = actualLicenses.get(0);
        assertNull(getResult1.getName());
        assertNull(getResult1.getIdentifier());
        assertFalse(getResult1.getAllowed());
    }

    @Test
    public void testGetLicenses4() {
        // Arrange
        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());

        // Act and Assert
        assertTrue(
            (new LicenseService(configuration, new ProjectLicenseService(new ConfigurationBridge(new MapSettings()))))
                .getLicenses(null)
                .isEmpty());
    }

    @Test
    public void testGetLicenses5() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.license-set", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);

        // Act
        List<License> actualLicenses = (new LicenseService(configuration,
            new ProjectLicenseService(new ConfigurationBridge(new MapSettings())))).getLicenses(null);

        // Assert
        assertEquals(1, actualLicenses.size());
        License getResult = actualLicenses.get(0);
        assertFalse(getResult.getAllowed());
        assertNull(getResult.getName());
        assertNull(getResult.getIdentifier());
    }

    @Test
    public void testGetLicenses6() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.license-set", "42");
        mapSettings.appendProperty("licensecheck.license-set", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);

        // Act
        List<License> actualLicenses = (new LicenseService(configuration,
            new ProjectLicenseService(new ConfigurationBridge(new MapSettings())))).getLicenses(null);

        // Assert
        assertEquals(2, actualLicenses.size());
        License getResult = actualLicenses.get(1);
        assertNull(getResult.getName());
        assertNull(getResult.getIdentifier());
        assertFalse(getResult.getAllowed());
        License getResult1 = actualLicenses.get(0);
        assertNull(getResult1.getName());
        assertNull(getResult1.getIdentifier());
        assertFalse(getResult1.getAllowed());
    }

    @Test
    public void testGetLicensesOld() {
        // Arrange
        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());

        // Act and Assert
        assertTrue(
            (new LicenseService(configuration, new ProjectLicenseService(new ConfigurationBridge(new MapSettings()))))
                .getLicensesOld()
                .isEmpty());
    }
}

