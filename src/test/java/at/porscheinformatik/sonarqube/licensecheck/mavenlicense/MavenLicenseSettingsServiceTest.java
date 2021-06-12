package at.porscheinformatik.sonarqube.licensecheck.mavenlicense;

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

public class MavenLicenseSettingsServiceTest {
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit10() {
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit11() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);
        MapSettings delegate = new MapSettings();
        DefaultDatabase database = new DefaultDatabase(null, null);

        MyBatis myBatis = new MyBatis(null);
        DBSessionsImpl dbSessions = new DBSessionsImpl(null);
        DbClient dbClient = new DbClient(database, myBatis, dbSessions, new CeTaskCharacteristicDao());

        PersistentSettings persistentSettings = new PersistentSettings(delegate, dbClient, new SettingsChangeNotifier());

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit12() {
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
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
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);
        MapSettings delegate = new MapSettings();
        DefaultDatabase database = new DefaultDatabase(null, null);

        MyBatis myBatis = new MyBatis(null);
        DBSessionsImpl dbSessions = new DBSessionsImpl(null);
        DbClient dbClient = new DbClient(database, myBatis, dbSessions, new CeTaskCharacteristicDao());

        PersistentSettings persistentSettings = new PersistentSettings(delegate, dbClient, new SettingsChangeNotifier());

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit5() {
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit6() {
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit7() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        // Arrange
        MapSettings mapSettings = new MapSettings();
        mapSettings.appendProperty("licensecheck.maven.license-mapping", "42");
        ConfigurationBridge configuration = new ConfigurationBridge(mapSettings);
        MapSettings delegate = new MapSettings();
        DefaultDatabase database = new DefaultDatabase(null, null);

        MyBatis myBatis = new MyBatis(null);
        DBSessionsImpl dbSessions = new DBSessionsImpl(null);
        DbClient dbClient = new DbClient(database, myBatis, dbSessions, new CeTaskCharacteristicDao());

        PersistentSettings persistentSettings = new PersistentSettings(delegate, dbClient, new SettingsChangeNotifier());

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit8() {
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }

    @Test
    public void testInit9() {
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

        // Act
        (new MavenLicenseSettingsService(persistentSettings, configuration,
            new MavenLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }
}

