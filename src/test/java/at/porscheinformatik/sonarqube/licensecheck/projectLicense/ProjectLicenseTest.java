package at.porscheinformatik.sonarqube.licensecheck.projectlicense;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProjectLicenseTest {
    @Test
    public void testConstructor() {
        // Arrange and Act
        ProjectLicense actualProjectLicense = new ProjectLicense("Project Key", "License", true);

        // Assert
        assertTrue(actualProjectLicense.getAllowed());
        assertEquals("License", actualProjectLicense.getLicense());
        assertEquals("Project Key", actualProjectLicense.getProjectKey());
    }

    @Test
    public void testConstructor2() {
        // Arrange and Act
        ProjectLicense actualProjectLicense = new ProjectLicense("Project Key", "License", "Allowed");

        // Assert
        assertFalse(actualProjectLicense.getAllowed());
        assertEquals("Project Key", actualProjectLicense.getProjectKey());
        assertEquals("License", actualProjectLicense.getLicense());
    }

    @Test
    public void testGetProjectKey() {
        assertEquals("Project Key", (new ProjectLicense("Project Key", "License", "Allowed")).getProjectKey());
    }

    @Test
    public void testGetLicense() {
        assertEquals("License", (new ProjectLicense("Project Key", "License", "Allowed")).getLicense());
    }

    @Test
    public void testGetAllowed() {
        assertFalse((new ProjectLicense("Project Key", "License", "Allowed")).getAllowed());
    }

    @Test
    public void testFromString() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        ProjectLicense.fromString("Project Licenses String");
    }

    @Test
    public void testFromString2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        ProjectLicense.fromString("at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense");
    }

    @Test
    public void testFromString3() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange and Act
        ProjectLicense.fromString("");
    }

    @Test
    public void testCompareTo() {
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", "Allowed");

        assertEquals(0, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo10() {
        // Arrange, Act and Assert
        assertEquals(1, (new ProjectLicense(null, "License", "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo11() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense(
            "at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense", "License", "Allowed");

        // Act and Assert
        assertEquals(17, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo12() {
        // Arrange, Act and Assert
        assertEquals(1, (new ProjectLicense("Project Key", null, "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo13() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key",
            "at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense", "Allowed");

        // Act and Assert
        assertEquals(21, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo14() {
        // Arrange, Act and Assert
        assertEquals(1, (new ProjectLicense("Project Key", "License", (Boolean) null)).compareTo(null));
    }

    @Test
    public void testCompareTo2() {
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", true);

        assertEquals(1, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo3() {
        assertEquals(1, (new ProjectLicense(null, "License", "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo4() {
        ProjectLicense projectLicense = new ProjectLicense(
            "at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense", "License", "Allowed");

        assertEquals(17, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo5() {
        assertEquals(1, (new ProjectLicense("Project Key", null, "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo6() {
        ProjectLicense projectLicense = new ProjectLicense("Project Key",
            "at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicense", "Allowed");

        assertEquals(21, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo7() {
        assertEquals(1, (new ProjectLicense("Project Key", "License", (Boolean) null)).compareTo(null));
    }

    @Test
    public void testCompareTo8() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", "Allowed");

        // Act and Assert
        assertEquals(0, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testCompareTo9() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", true);

        // Act and Assert
        assertEquals(1, projectLicense.compareTo(new ProjectLicense("Project Key", "License", "Allowed")));
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new ProjectLicense("Project Key", "License", "Allowed")).equals(null));
        assertFalse((new ProjectLicense("Project Key", "License", "Allowed")).equals("Different type to ProjectLicense"));
        assertFalse((new ProjectLicense("Project Key", "License", "Allowed")).equals(null));
        assertFalse((new ProjectLicense("Project Key", "License", "Allowed")).equals("Different type to ProjectLicense"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", "Allowed");

        // Act and Assert
        assertTrue(projectLicense.equals(projectLicense));
        int expectedHashCodeResult = projectLicense.hashCode();
        assertEquals(expectedHashCodeResult, projectLicense.hashCode());
    }

    @Test
    public void testEquals3() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", "Allowed");
        ProjectLicense projectLicense1 = new ProjectLicense("Project Key", "License", "Allowed");

        // Act and Assert
        assertTrue(projectLicense.equals(projectLicense1));
        int expectedHashCodeResult = projectLicense.hashCode();
        assertEquals(expectedHashCodeResult, projectLicense1.hashCode());
    }

    @Test
    public void testEquals4() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", "Allowed");

        // Act and Assert
        assertTrue(projectLicense.equals(projectLicense));
        int expectedHashCodeResult = projectLicense.hashCode();
        assertEquals(expectedHashCodeResult, projectLicense.hashCode());
    }

    @Test
    public void testEquals5() {
        // Arrange
        ProjectLicense projectLicense = new ProjectLicense("Project Key", "License", "Allowed");
        ProjectLicense projectLicense1 = new ProjectLicense("Project Key", "License", "Allowed");

        // Act and Assert
        assertTrue(projectLicense.equals(projectLicense1));
        int expectedHashCodeResult = projectLicense.hashCode();
        assertEquals(expectedHashCodeResult, projectLicense1.hashCode());
    }

    @Test
    public void testHashCode() {
        assertEquals(-1041396789, (new ProjectLicense("Project Key", "License", "Allowed")).hashCode());
    }
}

