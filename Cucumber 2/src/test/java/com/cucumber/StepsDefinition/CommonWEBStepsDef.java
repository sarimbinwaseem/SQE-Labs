package com.cucumber.StepsDefinition;

import com.mysql.cj.protocol.x.XServerCapabilities;
import io.cucumber.java.en.Given;

import static UtilFactory.ServiceFactory.serviceFactoryInstance;

public class CommonWEBStepsDef {

    @Given("User Setup Web Browser Session")
    public void userSetupWebBrowserSession() throws Exception {
        serviceFactoryInstance.setDriver(serviceFactoryInstance.getBrowser());
    }

}
