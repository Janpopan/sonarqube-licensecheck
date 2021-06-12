package at.porscheinformatik.sonarqube.licensecheck.mavenlicense;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MavenLicenseTest {
    @Test
    public void testGetLicense() {
        assertEquals("License", (new MavenLicense("Regex", "License")).getLicense());
    }

    @Test
    public void testCompareTo() {
        MavenLicense mavenLicense = new MavenLicense("Regex", "License");

        assertEquals(0, mavenLicense.compareTo(new MavenLicense("Regex", "License")));
    }

    @Test
    public void testCompareTo2() {
        assertEquals(1, (new MavenLicense("Regex", null)).compareTo(null));
    }

    @Test
    public void testCompareTo3() {
        MavenLicense mavenLicense = new MavenLicense("Regex", "[");

        // Act and Assert
        assertEquals(15, mavenLicense.compareTo(new MavenLicense("Regex", "License")));
    }
}

