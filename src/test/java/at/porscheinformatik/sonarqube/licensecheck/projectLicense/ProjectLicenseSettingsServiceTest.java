package at.porscheinformatik.sonarqube.licensecheck.projectlicense;

import org.junit.Test;
import org.sonar.api.config.internal.ConfigurationBridge;
import org.sonar.api.config.internal.MapSettings;
import org.sonar.db.DBSessionsImpl;
import org.sonar.db.DbClient;
import org.sonar.db.DefaultDatabase;
import org.sonar.db.MyBatis;
import org.sonar.db.ce.CeTaskCharacteristicDao;
import org.sonar.server.platform.PersistentSettings;
import org.sonar.server.setting.SettingsChangeNotifier;

public class ProjectLicenseSettingsServiceTest {
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
        (new ProjectLicenseSettingsService(persistentSettings, configuration,
            new ProjectLicenseService(new ConfigurationBridge(new MapSettings())))).init();
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

        ConfigurationBridge configuration = new ConfigurationBridge(new MapSettings());

        // Act
        (new ProjectLicenseSettingsService(persistentSettings, configuration,
            new ProjectLicenseService(new ConfigurationBridge(new MapSettings())))).init();
    }
}

