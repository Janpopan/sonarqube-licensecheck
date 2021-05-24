package at.porscheinformatik.sonarqube.licensecheck.mavendependency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sonar.api.config.PropertyDefinitions;
import org.sonar.api.config.internal.ConfigurationBridge;
import org.sonar.api.config.internal.MapSettings;
import org.sonar.api.utils.System2;

public class MavenDependencyServiceTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        MavenDependencyService actualMavenDependencyService = new MavenDependencyService(
            new ConfigurationBridge(new MapSettings()));

        // Assert
        List<MavenDependency> mavenDependencies = actualMavenDependencyService.getMavenDependencies();
        assertTrue(mavenDependencies instanceof ArrayList);
        List<MavenDependency> mavenDependenciesOld = actualMavenDependencyService.getMavenDependenciesOld();
        assertTrue(mavenDependenciesOld instanceof ArrayList);
        assertTrue(mavenDependencies.isEmpty());
        assertEquals(mavenDependencies, mavenDependenciesOld);
        assertTrue(mavenDependenciesOld.isEmpty());
    }

    @Test
    public void testGetMavenDependencies() {
        // Arrange, Act and Assert
        assertTrue(
            (new MavenDependencyService(new ConfigurationBridge(new MapSettings()))).getMavenDependencies().isEmpty());
    }

    @Test
    public void testGetMavenDependencies2() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.dep-mapping", "42");

        // Act
        List<MavenDependency> actualMavenDependencies = (new MavenDependencyService(new ConfigurationBridge(mapSettings)))
            .getMavenDependencies();

        // Assert
        assertEquals(1, actualMavenDependencies.size());
        MavenDependency getResult = actualMavenDependencies.get(0);
        assertNull(getResult.getKey());
        assertNull(getResult.getLicense());
    }

    @Test
    public void testGetMavenDependencies3() {
        // Arrange
        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
        mapSettings.appendProperty("licensecheck.maven.dep-mapping", "42");

        // Act
        List<MavenDependency> actualMavenDependencies = (new MavenDependencyService(new ConfigurationBridge(mapSettings)))
            .getMavenDependencies();

        // Assert
        assertEquals(1, actualMavenDependencies.size());
        MavenDependency getResult = actualMavenDependencies.get(0);
        assertNull(getResult.getKey());
        assertNull(getResult.getLicense());
    }

    @Test
    public void testGetMavenDependencies4() {
        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.dep-mapping", "42");
        mapSettings.appendProperty("licensecheck.maven.dep-mapping", "42");

        // Act
        List<MavenDependency> actualMavenDependencies = (new MavenDependencyService(new ConfigurationBridge(mapSettings)))
            .getMavenDependencies();

        // Assert
        assertEquals(2, actualMavenDependencies.size());
        MavenDependency getResult = actualMavenDependencies.get(1);
        assertNull(getResult.getLicense());
        assertNull(getResult.getKey());
        MavenDependency getResult1 = actualMavenDependencies.get(0);
        assertNull(getResult1.getLicense());
        assertNull(getResult1.getKey());
    }

    @Test
    public void testGetMavenDependenciesOld() {
        // Arrange, Act and Assert
        assertTrue(
            (new MavenDependencyService(new ConfigurationBridge(new MapSettings()))).getMavenDependenciesOld().isEmpty());
    }

//    @Test
//    public void testGetMavenDependenciesOld2() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings();
//        mapSettings.appendProperty("licensecheck.alloweddependencies", "42");
//
//        // Act
//        (new MavenDependencyService(new ConfigurationBridge(mapSettings))).getMavenDependenciesOld();
//    }
//
//    @Test
//    public void testGetMavenDependenciesOld3() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        // Arrange
//        MapSettings mapSettings = new MapSettings(new PropertyDefinitions(new System2(), "42", "42", "42"));
//        mapSettings.appendProperty("licensecheck.alloweddependencies", "42");
//
//        // Act
//        (new MavenDependencyService(new ConfigurationBridge(mapSettings))).getMavenDependenciesOld();
//    }
}

