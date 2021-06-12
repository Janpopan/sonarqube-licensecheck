package at.porscheinformatik.sonarqube.licensecheck.maven;

import static org.junit.Assert.assertThrows;

import at.porscheinformatik.sonarqube.licensecheck.Dependency;

import java.nio.file.Paths;

import org.junit.Test;

public class DirectoryFinderTest {
    @Test
    public void testGetPomPath() {
        // Arrange
        Dependency findPathOfDependency = new Dependency("Name", "1.0.2", "License");

        // Act and Assert
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> DirectoryFinder.getPomPath(findPathOfDependency,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    }

    @Test
    public void testGetPomPath2() {
        // Arrange
        Dependency findPathOfDependency = new Dependency(":", "1.0.2", "License");

        // Act and Assert
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> DirectoryFinder.getPomPath(findPathOfDependency,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    }

    @Test
    public void testGetMavenRepsitoryDir() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        DirectoryFinder.getMavenRepsitoryDir("User Settings", "Global Settings");
    }

    @Test
    public void testGetMavenRepsitoryDir2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        DirectoryFinder.getMavenRepsitoryDir(null, null);
    }
}

