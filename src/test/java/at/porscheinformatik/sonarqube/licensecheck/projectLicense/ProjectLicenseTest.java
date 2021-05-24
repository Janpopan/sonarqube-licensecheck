package at.porscheinformatik.sonarqube.licensecheck.projectlicense;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ProjectLicenseTest {
    @Test
    public void testGetProjectKey() {
        // Arrange, Act and Assert
        assertEquals("Project Key", (new ProjectLicense("Project Key", "License", "Allowed")).getProjectKey());
    }

    @Test
    public void testGetLicense() {
        // Arrange, Act and Assert
        assertEquals("License", (new ProjectLicense("Project Key", "License", "Allowed")).getLicense());
    }

    @Test
    public void testGetAllowed() {
        // Arrange, Act and Assert
        assertFalse((new ProjectLicense("Project Key", "License", "Allowed")).getAllowed());
    }

    @Test
    public void testCompareTo() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", "Allowed");

        // Act and Assert
        assertEquals(0, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo2() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", true);

        // Act and Assert
        assertEquals(1, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo3() {
        // Arrange, Act and Assert
        assertEquals(1, (new ProjectLicense(null, "License", "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo4() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense(
            "at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense", "License", "Allowed");

        // Act and Assert
        assertEquals(17, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo5() {
        // Arrange, Act and Assert
        assertEquals(1, (new ProjectLicense("Project Key", null, "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo6() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key",
            "at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense", "Allowed");

        // Act and Assert
        assertEquals(21, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo7() {
        // Arrange, Act and Assert
        assertEquals(1, (new ProjectLicense("Project Key", "License", (Boolean) null)).compareTo(null));
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(-1041396789, (new ProjectLicense("Project Key", "License", "Allowed")).hashCode());
    }
}

