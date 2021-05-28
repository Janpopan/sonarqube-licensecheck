package at.porscheinformatik.sonarqube.licensecheck.mavendependency;

import static org.junit.Assert.*;

import org.junit.Test;

public class MavenDependencyTest {
    @Test
    public void testGetKey() {
        assertEquals("Key", (new MavenDependency("Key", "License")).getKey());
    }

    @Test
    public void testSetKey() {
        MavenDependency mavenDependency = new MavenDependency("Key2", "License");
        mavenDependency.setKey("Key");
        assertEquals("Key", (mavenDependency.getKey()));
    }


    @Test
    public void testGetLicense() {
        assertEquals("License", (new MavenDependency("Key", "License")).getLicense());
    }

    @Test
    public void testToString() {
        assertEquals("{key:Key, license:License}", (new MavenDependency("Key", "License")).toString());
    }

    @Test
    public void testCompareTo() {
        MavenDependency mavenDependency = new MavenDependency("Key", "License");
        assertEquals(0, mavenDependency.compareTo(new MavenDependency("Key", "License")));
    }

    @Test
    public void testCompareTo2() {
        assertEquals(1, (new MavenDependency(null, "License")).compareTo(null));
    }

    @Test
    public void testCompareTo3() {
        MavenDependency mavenDependency = new MavenDependency(null, "License");
        mavenDependency.setLicense(null);
        assertEquals(1, mavenDependency.compareTo(null));
    }

    @Test
    public void testCompareTo4() {
        MavenDependency mavenDependency = new MavenDependency("Key",
            "at.porscheinformatik.sonarqube.licensecheck.mavendependency.MavenDependency");
        assertEquals(21, mavenDependency.compareTo(new MavenDependency("Key", "License")));
    }

    @Test
    public void testHashCode() {
        assertEquals(1833746819, (new MavenDependency("Key", "License")).hashCode());
    }

    @Test
    public void testEquals() {
        MavenDependency md1=new MavenDependency("Key", "License");
        MavenDependency md2=new MavenDependency("Key", "License");
        MavenDependency md3=new MavenDependency("Key1", "License1");
        Object o = new Object();

        assertTrue(md1.equals(md2));
        assertTrue(md1.equals(md1));
        assertFalse(md1.equals(md3));
        assertFalse(md1.equals(null));
        assertFalse(md1.equals(o));
    }
}

