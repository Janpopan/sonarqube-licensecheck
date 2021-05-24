package at.porscheinformatik.sonarqube.licensecheck;

import static org.junit.Assert.assertEquals;

import at.porscheinformatik.sonarqube.licensecheck.license.LicenseService;
import at.porscheinformatik.sonarqube.licensecheck.mavendependency.MavenDependencyService;
import at.porscheinformatik.sonarqube.licensecheck.mavenlicense.MavenLicenseService;
import at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicenseService;
import org.junit.Test;
import org.sonar.api.batch.sensor.internal.DefaultSensorDescriptor;
import org.sonar.api.config.internal.ConfigurationBridge;
import org.sonar.api.config.internal.MapSettings;

public class LicenseCheckSensorTest {
    @Test
    public void testDescribe() {
        // Arrange
        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());
        ConfigurationBridge configuration1 = new ConfigurationBridge(null);
        ValidateLicenses validateLicenses = new ValidateLicenses(
                new LicenseService(configuration1, new ProjectLicenseService(null)));
        MavenLicenseService mavenLicenseService = new MavenLicenseService(new ConfigurationBridge(new MapSettings()));
        LicenseCheckSensor licenseCheckSensor = new LicenseCheckSensor(null, configuration, validateLicenses,
                mavenLicenseService, new MavenDependencyService(new ConfigurationBridge(new MapSettings())));
        DefaultSensorDescriptor defaultSensorDescriptor = new DefaultSensorDescriptor();

        // Act
        licenseCheckSensor.describe(defaultSensorDescriptor);

        // Assert
        assertEquals(LicenseCheckPropertyKeys.CATEGORY, defaultSensorDescriptor.name());
    }
}

