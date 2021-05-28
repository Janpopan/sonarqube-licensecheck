package at.porscheinformatik.sonarqube.licensecheck;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import java.util.List;

import at.porscheinformatik.sonarqube.licensecheck.mavendependency.MavenDependency;
import org.junit.Test;

public class DependencyTest {
    private static final String DEPENDENCIES_JSON =
        "[{\"name\":\"another\",\"version\":\"2.1.0\",\"license\":\"MIT\",\"lang\":\"java\"}," +
            "{\"name\":\"library\",\"version\":\"1.0.0\",\"license\":\"Apache-2.0\",\"lang\":\"java\"}]";
    private static final String DEPENDENCIES_STRING = "another~2.1.0~MIT;library~1.0.0~Apache-2.0";
    private static final Dependency DEP1 = new Dependency("another", "2.1.0", "MIT");
    private static final Dependency DEP2 = new Dependency("library", "1.0.0", "Apache-2.0");

    @Test
    public void testConstructor() {
        Dependency actualDependency = new Dependency("Name", "1.0.2", "License");
        actualDependency.setStatus(Dependency.Status.Allowed);

        assertEquals(Dependency.Status.Allowed, actualDependency.getStatus());
    }

    @Test
    public void testGetName() {
        assertEquals("Name", (new Dependency("Name", "1.0.2", "License")).getName());
    }

    @Test
    public void testGetVersion() {
        assertEquals("1.0.2", (new Dependency("Name", "1.0.2", "License")).getVersion());
    }

    @Test
    public void testGetLicense() {
        assertEquals("License", (new Dependency("Name", "1.0.2", "License")).getLicense());
    }

    @Test
    public void testGetPomPath() {
        assertNull((new Dependency("Name", "1.0.2", "License")).getPomPath());
    }

    @Test
    public void testHashCode() {
        assertEquals(1309258900, (new Dependency("Name", "1.0.2", "License")).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("{name:Name, version:1.0.2, license:License}",
            (new Dependency("Name", "1.0.2", "License")).toString());
    }

    @Test
    public void testCompareTo() {
        Dependency dependency = new Dependency("Name", "1.0.2", "License");

        assertEquals(0, dependency.compareTo(new Dependency("Name", "1.0.2", "License")));
    }

    @Test
    public void testCompareTo2() {
        Dependency dependency = new Dependency(null, "1.0.2", "License");

        assertEquals(-1, dependency.compareTo(new Dependency("Name", "1.0.2", "License")));
    }

    @Test
    public void testCompareTo3() {
        Dependency dependency = new Dependency("Name", "1.0.2", "License");

        assertEquals(1, dependency.compareTo(new Dependency(null, "1.0.2", "License")));
    }

    @Test
    public void testCompareTo4() {
        assertEquals(1, (new Dependency("Name", "1.0.2", "License")).compareTo(null));
    }

    @Test
    public void testEquals() {
        Dependency d1=new Dependency("Name", "1.0.2", "License");
        Dependency d2=new Dependency("Name", "1.0.2", "License");
        Dependency d3=new Dependency("Name1", "1.0.2", "License1");
        Object o = new Object();

        assertTrue(d1.equals(d2));
        assertTrue(d1.equals(d1));
        assertFalse(d1.equals(d3));
        assertFalse(d1.equals(null));
        assertFalse(d1.equals(o));
    }


    @Test
    public void createString() {
        String dependenciesJson = Dependency.createString(asList(DEP2, DEP1));

        assertThat(dependenciesJson, equalTo(DEPENDENCIES_JSON));
    }

    @Test
    public void fromStringOld() {
        List<Dependency> dependencies = Dependency.fromString(DEPENDENCIES_STRING);

        assertThat(dependencies, hasItems(DEP1, DEP2));
    }

    @Test
    public void fromStringNew() {
        List<Dependency> dependencies = Dependency.fromString(DEPENDENCIES_JSON);

        assertThat(dependencies, hasItems(DEP1, DEP2));
    }
}
