package at.porscheinformatik.sonarqube.licensecheck.maven;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SettingTest {
    @Test
    public void testGetLocalRepositoryPath() {
        // Arrange, Act and Assert
        assertNull((new Setting()).getLocalRepositoryPath());
    }
}

