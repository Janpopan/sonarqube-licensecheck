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
    public void testConstructor() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: the constructed class does not have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the class.
        //   See https://diff.blue/R002

        // Arrange
        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());
        ConfigurationBridge configuration1 = new ConfigurationBridge(new MapSettings());
        ValidateLicenses validateLicenses = new ValidateLicenses(
            new LicenseService(configuration1, new ProjectLicenseService(new ConfigurationBridge(null))));
        MavenLicenseService mavenLicenseService = new MavenLicenseService(new ConfigurationBridge(new MapSettings()));

        // Act
        new LicenseCheckSensor(null, configuration, validateLicenses, mavenLicenseService,
            new MavenDependencyService(new ConfigurationBridge(new MapSettings())));
    }

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

    @Test
    public void testDescribe2() {
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

    @Test
    public void testExecute() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty(LicenseCheckPropertyKeys.ACTIVATION_KEY, "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);
        ConfigurationBridge configuration1 = new ConfigurationBridge(null);
        ValidateLicenses validateLicenses = new ValidateLicenses(
            new LicenseService(configuration1, new ProjectLicenseService(null)));
        MavenLicenseService mavenLicenseService = new MavenLicenseService(new ConfigurationBridge(new MapSettings()));

        // Act
        (new LicenseCheckSensor(null, configuration, validateLicenses, mavenLicenseService,
            new MavenDependencyService(new ConfigurationBridge(new MapSettings())))).execute(null);
    }

    @Test
    public void testExecute2() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty(LicenseCheckPropertyKeys.ACTIVATION_KEY, "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);
        ConfigurationBridge configuration1 = new ConfigurationBridge(null);
        ValidateLicenses validateLicenses = new ValidateLicenses(
            new LicenseService(configuration1, new ProjectLicenseService(null)));
        MavenLicenseService mavenLicenseService = new MavenLicenseService(new ConfigurationBridge(new MapSettings()));

        // Act
        (new LicenseCheckSensor(null, configuration, validateLicenses, mavenLicenseService,
            new MavenDependencyService(new ConfigurationBridge(new MapSettings())))).execute(null);
    }
}

