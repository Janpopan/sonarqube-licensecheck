package at.porscheinformatik.sonarqube.licensecheck.projectlicense;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sonar.api.config.PropertyDefinitions;
import org.sonar.api.config.internal.ConfigurationBridge;
import org.sonar.api.config.internal.MapSettings;
import org.sonar.api.utils.System2;

public class ProjectLicenseServiceTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        ProjectLicenseService actualProjectLicenseService = new ProjectLicenseService(
            new ConfigurationBridge(new MapSettings()));

        // Assert
        List<ProjectLicense> projectLicenseList = actualProjectLicenseService.getProjectLicenseList();
        assertTrue(projectLicenseList instanceof ArrayList);
        List<ProjectLicense> projectLicenseListOld = actualProjectLicenseService.getProjectLicenseListOld();
        assertTrue(projectLicenseListOld instanceof ArrayList);
        assertTrue(projectLicenseList.isEmpty());
        assertEquals(projectLicenseList, projectLicenseListOld);
        assertTrue(projectLicenseListOld.isEmpty());
    }

    @Test
    public void testGetProjectLicenseList() {
        // Arrange, Act and Assert
        assertTrue(
            (new ProjectLicenseService(new ConfigurationBridge(new MapSettings()))).getProjectLicenseList().isEmpty());
    }

    @Test
    public void testGetProjectLicenseList2() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.project-license-set", "42");

        // Act
        List<ProjectLicense> actualProjectLicenseList = (new ProjectLicenseService(new ConfigurationBridge(mapSettings)))
            .getProjectLicenseList();

        // Assert
        assertEquals(1, actualProjectLicenseList.size());
        ProjectLicense getResult = actualProjectLicenseList.get(0);
        assertFalse(getResult.getAllowed());
        assertNull(getResult.getProjectKey());
        assertNull(getResult.getLicense());
    }

    @Test
    public void testGetProjectLicenseList3() {
        // Arrange
        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
        mapSettings.appendProperty("licensecheck.project-license-set", "42");

        // Act
        List<ProjectLicense> actualProjectLicenseList = (new ProjectLicenseService(new ConfigurationBridge(mapSettings)))
            .getProjectLicenseList();

        // Assert
        assertEquals(1, actualProjectLicenseList.size());
        ProjectLicense getResult = actualProjectLicenseList.get(0);
        assertFalse(getResult.getAllowed());
        assertNull(getResult.getProjectKey());
        assertNull(getResult.getLicense());
    }

    @Test
    public void testGetProjectLicenseList4() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.project-license-set", "42");
        mapSettings.appendProperty("licensecheck.project-license-set", "42");

        // Act
        List<ProjectLicense> actualProjectLicenseList = (new ProjectLicenseService(new ConfigurationBridge(mapSettings)))
            .getProjectLicenseList();

        // Assert
        assertEquals(2, actualProjectLicenseList.size());
        ProjectLicense getResult = actualProjectLicenseList.get(0);
        assertNull(getResult.getProjectKey());
        ProjectLicense getResult1 = actualProjectLicenseList.get(1);
        assertNull(getResult1.getProjectKey());
        assertNull(getResult1.getLicense());
        assertFalse(getResult1.getAllowed());
        assertNull(getResult.getLicense());
        assertFalse(getResult.getAllowed());
    }

    @Test
    public void testGetProjectLicenseListOld() {
        // Arrange, Act and Assert
        assertTrue(
            (new ProjectLicenseService(new ConfigurationBridge(new MapSettings()))).getProjectLicenseListOld().isEmpty());
    }

//    @Test
//    public void testGetProjectLicenseListOld2() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings();
//        mapSettings.appendProperty("licensecheck.projectlicense", "42");
//
//        // Act
//        (new ProjectLicenseService(new ConfigurationBridge(mapSettings))).getProjectLicenseListOld();
//    }
//
//    @Test
//    public void testGetProjectLicenseListOld3() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
//        mapSettings.appendProperty("licensecheck.projectlicense", "42");
//
//        // Act
//        (new ProjectLicenseService(new ConfigurationBridge(mapSettings))).getProjectLicenseListOld();
//    }
//
//    @Test
//    public void testGetProjectLicenseListOld4() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings();
//        mapSettings.appendProperty("licensecheck.projectlicense", ",");
//
//        // Act
//        (new ProjectLicenseService(new ConfigurationBridge(mapSettings))).getProjectLicenseListOld();
//    }
}

