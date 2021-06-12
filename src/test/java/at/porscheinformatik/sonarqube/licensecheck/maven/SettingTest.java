package at.porscheinformatik.sonarqube.licensecheck.maven;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SettingTest {
    @Test
    public void testGetLocalRepositoryPath() {
        assertNull((new Setting()).getLocalRepositoryPath());
    }
}

