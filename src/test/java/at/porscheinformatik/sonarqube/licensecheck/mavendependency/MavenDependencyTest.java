package at.porscheinformatik.sonarqube.licensecheck.mavendependency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MavenDependencyTest {
    @Test
    public void testGetKey() {
        // Arrange, Act and Assert
        assertEquals("Key", (new MavenDependency("Key", "License")).getKey());
    }

    @Test
    public void testGetLicense() {
        // Arrange, Act and Assert
        assertEquals("License", (new MavenDependency("Key", "License")).getLicense());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("{key:Key, license:License}", (new MavenDependency("Key", "License")).toString());
    }

    @Test
    public void testCompareTo() {
        // Arrange
        MavenDependency mavenDependency = new MavenDependency("Key", "License");

        // Act and Assert
        assertEquals(0, mavenDependency.compareTo(new MavenDependency("Key", "License")));
    }

    @Test
    public void testCompareTo2() {
        // Arrange, Act and Assert
        assertEquals(1, (new MavenDependency(null, "License")).compareTo(null));
    }

    @Test
    public void testCompareTo3() {
        // Arrange
        MavenDependency mavenDependency = new MavenDependency(null, "License");
        mavenDependency.setLicense(null);

        // Act and Assert
        assertEquals(1, mavenDependency.compareTo(null));
    }

    @Test
    public void testCompareTo4() {
        // Arrange
        MavenDependency mavenDependency = new MavenDependency("Key",
            "at.porscheinformatik.sonarqube.licensecheck.mavendependency.MavenDependency");

        // Act and Assert
        assertEquals(21, mavenDependency.compareTo(new MavenDependency("Key", "License")));
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(1833746819, (new MavenDependency("Key", "License")).hashCode());
    }
}

