package Runner;

import UtilFactory.ServiceFactory;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.*;

import static UtilFactory.ServiceFactory.getDriver;

public class TestRunnerListener implements ITestListener, IExecutionListener {

    public TestRunnerListener() throws Exception{}

    public String getParameterValue(String key) {
        return Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(key);
    }
    private final ServiceFactory serviceFactoryInstance;

    {
        try {
            serviceFactoryInstance = ServiceFactory.getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        serviceFactoryInstance.setBrowser(getParameterValue("browser"));
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        if(getDriver() != null) {getDriver().quit();}

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        if(getDriver() != null) {getDriver().quit();}

    }

//    @Override
//    public void onTestFinish(ITestContext iTestContext) {
//
//    }
}
