package at.porscheinformatik.sonarqube.licensecheck.license;

import at.porscheinformatik.sonarqube.licensecheck.projectlicense.ProjectLicenseService;

import java.util.Properties;

import org.junit.Test;
import org.sonar.api.config.PropertyDefinitions;
import org.sonar.api.config.internal.ConfigurationBridge;
import org.sonar.api.config.internal.MapSettings;
import org.sonar.api.utils.System2;
import org.sonar.db.DBSessionsImpl;
import org.sonar.db.DbClient;
import org.sonar.db.DefaultDatabase;
import org.sonar.db.MyBatis;
import org.sonar.db.ce.CeTaskCharacteristicDao;
import org.sonar.server.platform.PersistentSettings;
import org.sonar.server.setting.ChildSettings;
import org.sonar.server.setting.SettingsChangeNotifier;
import org.sonar.server.setting.ThreadLocalSettings;

public class LicenseSettingsServiceTest {
    @Test
    public void testInit() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings delegate = new MapSettings();
        DefaultDatabase database = new DefaultDatabase(null, null);

        MyBatis myBatis = new MyBatis(null);
        DBSessionsImpl dbSessions = new DBSessionsImpl(null);
        DbClient dbClient = new DbClient(database, myBatis, dbSessions, new CeTaskCharacteristicDao());

        PersistentSettings persistentSettings = new PersistentSettings(delegate, dbClient, new SettingsChangeNotifier());

        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());
        ConfigurationBridge configuration1 = new ConfigurationBridge(new MapSettings());

        // Act
        (new LicenseSettingsService(persistentSettings, configuration,
                new LicenseService(configuration1, new ProjectLicenseService(new ConfigurationBridge(null))))).init();
    }

    @Test
    public void testInit2() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings delegate = new MapSettings();
        DefaultDatabase database = new DefaultDatabase(null, null);

        MyBatis myBatis = new MyBatis(null);
        DBSessionsImpl dbSessions = new DBSessionsImpl(null);
        DbClient dbClient = new DbClient(database, myBatis, dbSessions, new CeTaskCharacteristicDao());

        PersistentSettings persistentSettings = new PersistentSettings(delegate, dbClient, new SettingsChangeNotifier());

        ConfigurationBridge configuration = new ConfigurationBridge(new ChildSettings(new MapSettings()));
        ConfigurationBridge configuration1 = new ConfigurationBridge(new MapSettings());

        // Act
        (new LicenseSettingsService(persistentSettings, configuration,
                new LicenseService(configuration1, new ProjectLicenseService(new ConfigurationBridge(null))))).init();
    }

    @Test
    public void testInit3() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.license-set", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);
        MapSettings delegate = new MapSettings();
        DefaultDatabase database = new DefaultDatabase(null, null);

        MyBatis myBatis = new MyBatis(null);
        DBSessionsImpl dbSessions = new DBSessionsImpl(null);
        DbClient dbClient = new DbClient(database, myBatis, dbSessions, new CeTaskCharacteristicDao());

        PersistentSettings persistentSettings = new PersistentSettings(delegate, dbClient, new SettingsChangeNotifier());

        ConfigurationBridge configuration1 = new ConfigurationBridge(new MapSettings());

        // Act
        (new LicenseSettingsService(persistentSettings, configuration,
                new LicenseService(configuration1, new ProjectLicenseService(new ConfigurationBridge(null))))).init();
    }

    @Test
    public void testInit4() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings delegate = new MapSettings();
        DefaultDatabase database = new DefaultDatabase(null, null);

        MyBatis myBatis = new MyBatis(null);
        DBSessionsImpl dbSessions = new DBSessionsImpl(null);
        DbClient dbClient = new DbClient(database, myBatis, dbSessions, new CeTaskCharacteristicDao());

        PersistentSettings persistentSettings = new PersistentSettings(delegate, dbClient, new SettingsChangeNotifier());

        PropertyDefinitions definitions = new PropertyDefinitions(new System2(), "42", "42", "42");

        ConfigurationBridge configuration = new ConfigurationBridge(new ThreadLocalSettings(definitions, new Properties()));
        ConfigurationBridge configuration1 = new ConfigurationBridge(new MapSettings());

        // Act
        (new LicenseSettingsService(persistentSettings, configuration,
                new LicenseService(configuration1, new ProjectLicenseService(new ConfigurationBridge(null))))).init();
    }
}

