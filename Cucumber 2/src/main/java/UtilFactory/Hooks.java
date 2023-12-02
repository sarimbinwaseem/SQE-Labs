package UtilFactory;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static UtilFactory.UtilFactory.*;
public class Hooks {
    @Before
    public void beforeTest(Scenario scenario) {
        scenarioName = scenario.getName();
        scenarioDef = features.createNode(scenarioName);
    }
}
