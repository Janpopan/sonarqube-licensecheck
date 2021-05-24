package at.porscheinformatik.sonarqube.licensecheck.license;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class LicenseTest {
    @Test
    public void testGetName() {
        // Arrange, Act and Assert
        assertEquals("Name", (new License("Name", "42", "Allowed")).getName());
        assertEquals("Name", (new License("Name", "42", "Allowed")).getName());
    }

    @Test
    public void testGetIdentifier() {
        // Arrange, Act and Assert
        assertEquals("42", (new License("Name", "42", "Allowed")).getIdentifier());
        assertEquals("42", (new License("Name", "42", "Allowed")).getIdentifier());
    }

    @Test
    public void testGetAllowed() {
        // Arrange, Act and Assert
        assertFalse((new License("Name", "42", "Allowed")).getAllowed());
        assertFalse((new License("Name", "42", "Allowed")).getAllowed());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("{name:Name, identifier:42, status:false}", (new License("Name", "42", "Allowed")).toString());
        assertEquals("{name:Name, identifier:42, status:false}", (new License("Name", "42", "Allowed")).toString());
    }

    @Test
    public void testCompareTo() {
        // Arrange
        License license = new License("Name", "42", "Allowed");

        // Act and Assert
        assertEquals(0, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo10() {
        // Arrange
        License license = new License("[", "42", "Allowed");

        // Act and Assert
        assertEquals(13, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo11() {
        // Arrange, Act and Assert
        assertEquals(1, (new License("Name", null, "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo12() {
        // Arrange
        License license = new License("Name", "Identifier", "Allowed");

        // Act and Assert
        assertEquals(21, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo2() {
        // Arrange
        License license = new License("Name", "42", true);

        // Act and Assert
        assertEquals(1, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo3() {
        // Arrange, Act and Assert
        assertEquals(1, (new License(null, "42", "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo4() {
        // Arrange
        License license = new License("[", "42", "Allowed");

        // Act and Assert
        assertEquals(13, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo5() {
        // Arrange, Act and Assert
        assertEquals(1, (new License("Name", null, "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo6() {
        // Arrange
        License license = new License("Name", "Identifier", "Allowed");

        // Act and Assert
        assertEquals(21, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo7() {
        // Arrange
        License license = new License("Name", "42", "Allowed");

        // Act and Assert
        assertEquals(0, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo8() {
        // Arrange
        License license = new License("Name", "42", true);

        // Act and Assert
        assertEquals(1, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo9() {
        // Arrange, Act and Assert
        assertEquals(1, (new License(null, "42", "Allowed")).compareTo(null));
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(-1968885151, (new License("Name", "42", "Allowed")).hashCode());
        assertEquals(-1968885151, (new License("Name", "42", "Allowed")).hashCode());
    }
}

