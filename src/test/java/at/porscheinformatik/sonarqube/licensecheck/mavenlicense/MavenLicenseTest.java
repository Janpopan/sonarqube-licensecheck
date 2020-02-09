package at.porscheinformatik.sonarqube.licensecheck.mavenlicense;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class MavenLicenseTest {
    private static final String LICENSE = "Apache-2.0";
    private static final Pattern REGEX = Pattern.compile("A*.*");
    private static final MavenLicense MLA = new MavenLicense("A*.*", "Apache-2.0");
    private static final MavenLicense MLB = new MavenLicense("B*.*", "Bapache-2.0");

    private static final String MLS2 = "[{\"regex\":\"Apple License\",\"license\":\"AML\"}]";
    private static final String MLS3 = "[{\"regex\":\"\",\"license\":\"AML\"}]";
    private static final String MLS4 = "[{\"rege\":\"\",\"license\":\"AML\"}]";
    //private static final String MLS5 = "{\"regex\":\"\",\"license\":\"AML\"}]";

    @Test
    public void testGetLicense() throws Exception {
        String glicense = new MavenLicense("A*.*", "Apache-2.0").getLicense();
        assertThat(glicense, equalTo(LICENSE));
    }

    @Test
    public void testGetRegex() throws Exception {
        String rlicense = new MavenLicense("A*.*", "Apache-2.0").getRegex().toString();
        assertThat(rlicense, equalTo(REGEX.pattern()));

    }

    @Test
    public void testCompareTo() throws Exception {
        MavenLicense MLT = new MavenLicense("A*.*", "Apache-2.0");
        assertThat(MLT.compareTo(null), equalTo(1));
        assertThat(MLT.compareTo(MLA), equalTo(0));
        assertThat(MLT.compareTo(MLB), equalTo(-1));

    }

    @Test
    public void testFromString() throws Exception {
        List<MavenLicense> mavenLicenses = new ArrayList<>();
        List<MavenLicense> MLS3 = new ArrayList<>();

        mavenLicenses = MavenLicense.fromString(null);
        mavenLicenses = MavenLicense.fromString(MLS2);
        MLS3 = MavenLicense.fromString(MLS2);
        Assert.assertEquals(mavenLicenses.get(0).getLicense(), MLS3.get(0).getLicense());
    }

    @Test
    public void testCreateString() throws Exception {
        Collection<MavenLicense> mavenLicenses = new ArrayList<>();
        mavenLicenses = MavenLicense.fromString(MLS2);
        String MLS2C = MavenLicense.createString(mavenLicenses);
        Assert.assertEquals(MLS2C, MLS2);
        mavenLicenses = MavenLicense.fromString(MLS3);
        mavenLicenses = MavenLicense.fromString(MLS4);
        // mavenLicenses = MavenLicense.fromString(MLS5);

    }

}
