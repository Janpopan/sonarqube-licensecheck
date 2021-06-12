package at.porscheinformatik.sonarqube.licensecheck.license;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class LicenseTest {
    @Test
    public void testGetName() {
        assertEquals("Name", (new License("Name", "42", "Allowed")).getName());
        assertEquals("Name", (new License("Name", "42", "Allowed")).getName());
    }

    @Test
    public void testGetIdentifier() {
        assertEquals("42", (new License("Name", "42", "Allowed")).getIdentifier());
        assertEquals("42", (new License("Name", "42", "Allowed")).getIdentifier());
    }

    @Test
    public void testGetAllowed() {
        assertFalse((new License("Name", "42", "Allowed")).getAllowed());
        assertFalse((new License("Name", "42", "Allowed")).getAllowed());
    }

    @Test
    public void testToString() {
        assertEquals("{name:Name, identifier:42, status:false}", (new License("Name", "42", "Allowed")).toString());
        assertEquals("{name:Name, identifier:42, status:false}", (new License("Name", "42", "Allowed")).toString());
    }

    @Test
    public void testCompareTo() {
        License license = new License("Name", "42", "Allowed");

        assertEquals(0, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo10() {
        License license = new License("[", "42", "Allowed");

        assertEquals(13, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo11() {
        assertEquals(1, (new License("Name", null, "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo12() {
        License license = new License("Name", "Identifier", "Allowed");

        assertEquals(21, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo2() {
        License license = new License("Name", "42", true);

        assertEquals(1, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo3() {
        assertEquals(1, (new License(null, "42", "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo4() {
        License license = new License("[", "42", "Allowed");

        assertEquals(13, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo5() {
        assertEquals(1, (new License("Name", null, "Allowed")).compareTo(null));
    }

    @Test
    public void testCompareTo6() {
        License license = new License("Name", "Identifier", "Allowed");

        assertEquals(21, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo7() {
        License license = new License("Name", "42", "Allowed");

        assertEquals(0, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo8() {
        License license = new License("Name", "42", true);

        assertEquals(1, license.compareTo(new License("Name", "42", "Allowed")));
    }

    @Test
    public void testCompareTo9() {
        assertEquals(1, (new License(null, "42", "Allowed")).compareTo(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1968885151, (new License("Name", "42", "Allowed")).hashCode());
        assertEquals(-1968885151, (new License("Name", "42", "Allowed")).hashCode());
    }
}

