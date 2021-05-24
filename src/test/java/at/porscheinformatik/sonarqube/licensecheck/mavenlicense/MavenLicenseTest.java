package at.porscheinformatik.sonarqube.licensecheck.mavenlicense;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MavenLicenseTest {
    @Test
    public void testGetRegex() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        (new MavenLicense("Regex", "License")).getRegex();
    }

    @Test
    public void testGetLicense() {
        // Arrange, Act and Assert
        assertEquals("License", (new MavenLicense("Regex", "License")).getLicense());
    }

    @Test
    public void testCompareTo() {
        // Arrange
        MavenLicense mavenLicense = new MavenLicense("Regex", "License");

        // Act and Assert
        assertEquals(0, mavenLicense.compareTo(new MavenLicense("Regex", "License")));
    }

    @Test
    public void testCompareTo2() {
        // Arrange, Act and Assert
        assertEquals(1, (new MavenLicense("Regex", null)).compareTo(null));
    }

    @Test
    public void testCompareTo3() {
        // Arrange
        MavenLicense mavenLicense = new MavenLicense("Regex", "[");

        // Act and Assert
        assertEquals(15, mavenLicense.compareTo(new MavenLicense("Regex", "License")));
    }

    @Test
    public void testHashCode() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        (new MavenLicense("Regex", "License")).hashCode();
    }
}

