package at.porscheinformatik.sonarqube.licensecheck;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.sonar.api.server.rule.RulesDefinition;

public class LicenseCheckRulesDefinitionTest
{
    @Test
    public void define()
    {
        RulesDefinition.Context context = new RulesDefinition.Context();

        new LicenseCheckRulesDefinition().define(context);

        assertThat(context.repositories().size(), is(3));
        for (RulesDefinition.Repository repository : context.repositories())
        {
            assertThat(repository.rules().size(), is(2));
        }
    }
}

public class LicenseCheckRulesDefinitionTest {
    @Test
    public void testDefine() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange
        LicenseCheckRulesDefinition licenseCheckRulesDefinition = new LicenseCheckRulesDefinition();

        // Act
        licenseCheckRulesDefinition.define(new RulesDefinition.Context());
    }

    @Test
    public void testDefine2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange
        LicenseCheckRulesDefinition licenseCheckRulesDefinition = new LicenseCheckRulesDefinition();

        RulesDefinition.Context context = new RulesDefinition.Context();
        context.setCurrentPluginKey(LicenseCheckMetrics.LICENSE_CHECK_KEY);

        // Act
        licenseCheckRulesDefinition.define(context);
    }

    @Test
    public void testDefine3() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange
        LicenseCheckRulesDefinition licenseCheckRulesDefinition = new LicenseCheckRulesDefinition();

        // Act
        licenseCheckRulesDefinition.define(new RulesDefinition.Context());
    }

    @Test
    public void testDefine4() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        // Arrange
        LicenseCheckRulesDefinition licenseCheckRulesDefinition = new LicenseCheckRulesDefinition();

        RulesDefinition.Context context = new RulesDefinition.Context();
        context.setCurrentPluginKey(LicenseCheckMetrics.LICENSE_CHECK_KEY);

        // Act
        licenseCheckRulesDefinition.define(context);
    }
}
