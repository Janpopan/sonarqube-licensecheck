package at.porscheinformatik.sonarqube.licensecheck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LicenseCheckMetricsTest {
    @Test
    public void testGetMetrics() {
        // Arrange, Act and Assert
        assertEquals(7, (new LicenseCheckMetrics()).getMetrics().size());
    }
}

