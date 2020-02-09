package at.porscheinformatik.sonarqube.licensecheck;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class DependencyTest {
    private static final String DEPENDENCIES_JSON = "[{\"name\":\"another\",\"version\":\"2.1.0\",\"license\":\"MIT\"},"
            + "{\"name\":\"library\",\"version\":\"1.0.0\",\"license\":\"Apache-2.0\"}]";
    private static final String DEPENDENCIES_STRING = "another~2.1.0~MIT;library~1.0.0~Apache-2.0";
    private static final String DEPENDENCIES_STRING2 = "{name:another, version:2.1.0, license:MIT}";
    private static final Dependency DEP1 = new Dependency("another", "2.1.0", "MIT");
    private static final Dependency DEP2 = new Dependency("library", "1.0.0", "Apache-2.0");
    private Dependency DEP3 = new Dependency("library", "1.0.0", "Apache-2.0");

    @Test
    public void testCreateString() {
        String dependenciesJson = Dependency.createString(asList(DEP2, DEP1));

        assertThat(dependenciesJson, equalTo(DEPENDENCIES_JSON));
    }

    @Test
    public void testFromStringOld() {
        List<Dependency> dependencies = Dependency.fromString(DEPENDENCIES_STRING);

        assertThat(dependencies, hasItems(DEP1, DEP2));
    }

    @Test
    public void testFromStringNew() {
        List<Dependency> dependencies = Dependency.fromString(DEPENDENCIES_JSON);

        assertThat(dependencies, hasItems(DEP1, DEP2));
    }

    @Test
    public void testSetStatus() {
        DEP3.setStatus("Forbidden");
        assertThat(DEP3.getStatus(), equalTo("Forbidden"));
    }

    @Test
    public void testGetStatus() {

        assertThat(DEP3.getStatus(), equalTo(null));

        DEP3.setStatus("Allowed");
        assertThat(DEP3.getStatus(), equalTo("Allowed"));

        DEP3.setStatus("Unknown");
        assertThat(DEP3.getStatus(), equalTo("Unknown"));

        DEP3.setStatus("Forbidden");
        assertThat(DEP3.getStatus(), equalTo("Forbidden"));
    }

    @Test
    public void testSetVersion() {

        assertThat(DEP3.getVersion(), equalTo("1.0.0"));

        DEP3.setVersion("1.2.3");
        assertThat(DEP3.getVersion(), equalTo("1.2.3"));
    }

    @Test
    public void testSetName() {

        assertThat(DEP3.getName(), equalTo("library"));

        DEP3.setName("library_new");
        assertThat(DEP3.getName(), equalTo("library_new"));
    }

    @Test
    public void testToString() {

        String dependenciesString = DEP1.toString();
        
        assertThat(dependenciesString, equalTo(DEPENDENCIES_STRING2));
    }

}
