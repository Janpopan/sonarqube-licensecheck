package at.porscheinformatik.sonarqube.licensecheck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LicenseCheckMetricsTest {
    @Test
    public void testGetMetrics() {
        assertEquals(7, (new LicenseCheckMetrics()).getMetrics().size());
    }
}

