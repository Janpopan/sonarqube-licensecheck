package at.porscheinformatik.sonarqube.licensecheck;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class DependencyTest {
    private static final String DEPENDENCIES_JSON =
        "[{\"name\":\"another\",\"version\":\"2.1.0\",\"license\":\"MIT\"}," +
            "{\"name\":\"library\",\"version\":\"1.0.0\",\"license\":\"Apache-2.0\"}]";
    private static final String DEPENDENCIES_STRING = "another~2.1.0~MIT;library~1.0.0~Apache-2.0";
    private static final Dependency DEP1 = new Dependency("another", "2.1.0", "MIT");
    private static final Dependency DEP2 = new Dependency("library", "1.0.0", "Apache-2.0");

    @Test
    public void testConstructor() {
        // Arrange and Act
        Dependency actualDependency = new Dependency("Name", "1.0.2", "License");
        actualDependency.setStatus(Dependency.Status.Allowed);

        // Assert
        assertEquals(Dependency.Status.Allowed, actualDependency.getStatus());
    }

    @Test
    public void testGetName() {
        // Arrange, Act and Assert
        assertEquals("Name", (new Dependency("Name", "1.0.2", "License")).getName());
    }

    @Test
    public void testGetVersion() {
        // Arrange, Act and Assert
        assertEquals("1.0.2", (new Dependency("Name", "1.0.2", "License")).getVersion());
    }

    @Test
    public void testGetLicense() {
        // Arrange, Act and Assert
        assertEquals("License", (new Dependency("Name", "1.0.2", "License")).getLicense());
    }

    @Test
    public void testGetPomPath() {
        // Arrange, Act and Assert
        assertNull((new Dependency("Name", "1.0.2", "License")).getPomPath());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(1309258900, (new Dependency("Name", "1.0.2", "License")).hashCode());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("{name:Name, version:1.0.2, license:License}",
            (new Dependency("Name", "1.0.2", "License")).toString());
    }

    @Test
    public void testCompareTo() {
        // Arrange
        Dependency dependency = new Dependency("Name", "1.0.2", "License");

        // Act and Assert
        assertEquals(0, dependency.compareTo(new Dependency("Name", "1.0.2", "License")));
    }

    @Test
    public void testCompareTo2() {
        // Arrange
        Dependency dependency = new Dependency(null, "1.0.2", "License");

        // Act and Assert
        assertEquals(-1, dependency.compareTo(new Dependency("Name", "1.0.2", "License")));
    }

    @Test
    public void testCompareTo3() {
        // Arrange
        Dependency dependency = new Dependency("Name", "1.0.2", "License");

        // Act and Assert
        assertEquals(1, dependency.compareTo(new Dependency(null, "1.0.2", "License")));
    }

    @Test
    public void testCompareTo4() {
        // Arrange, Act and Assert
        assertEquals(1, (new Dependency("Name", "1.0.2", "License")).compareTo(null));
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
