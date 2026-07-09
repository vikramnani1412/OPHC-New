package genericUtilities;

	import java.io.IOException;
	import java.util.Map;
	import java.util.concurrent.ConcurrentHashMap;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	/**
	 * Advanced TestNG listener with thread-safe ExtentTest mapping,
	 * category/author tagging, screenshot embedding, and retry-aware logging.
	 *
	 * @author vikra
	 */
	public class AdminListnersImplementationClass implements ITestListener {

	    private static ExtentReports report;
	    // ThreadLocal-safe map keyed by test result hashcode, supports parallel execution
	    private static final Map<Long, ExtentTest> testMap = new ConcurrentHashMap<>();

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("--> Suite Execution Started: " + context.getName() + " <--");

	        if (report == null) {
	            synchronized (AdminListnersImplementationClass.class) {
	                if (report == null) {
	                    String reportPath = ".\\Extent Reports\\Report-"
	                            + new JavaUtility().getSystemDateInFormat() + ".html";

	                    ExtentSparkReporter htmlReport = new ExtentSparkReporter(reportPath);
	                    htmlReport.config().setDocumentTitle("OPHC Execution Report");
	                    htmlReport.config().setReportName("OPHC-Automation Report");
	                    htmlReport.config().setTheme(Theme.STANDARD);
	                    htmlReport.config().setEncoding("utf-8");

	                    report = new ExtentReports();
	                    report.attachReporter(htmlReport);
	                    report.setSystemInfo("Base Browser", System.getProperty("browser", "Chrome"));
	                    report.setSystemInfo("Base URL's", "https://stg-admin-ui.ophc.in/");
	                    report.setSystemInfo("Base Platform", System.getProperty("os.name"));
	                    report.setSystemInfo("Reporter Name", "Vikram Gangavarapu");
	                    report.setSystemInfo("Environment", System.getProperty("env", "STAGING"));
	                }
	            }
	        }
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        String methodName = result.getMethod().getMethodName();
	        ExtentTest test = report.createTest(methodName, result.getMethod().getDescription());

	        // Tag with groups (categories) and class name for filtering in report
	        for (String group : result.getMethod().getGroups()) {
	            test.assignCategory(group);
	        }
	        test.assignAuthor(result.getTestClass().getName());

	        testMap.put(getId(result), test);
	        test.log(Status.INFO, methodName + " -> Test Execution Started");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        ExtentTest test = getTest(result);
	        long duration = result.getEndMillis() - result.getStartMillis();
	        test.log(Status.PASS, result.getMethod().getMethodName()
	                + " -> Test Passed (" + duration + " ms)");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        ExtentTest test = getTest(result);
	        String methodName = result.getMethod().getMethodName();

	        test.log(Status.FAIL, methodName + " -> Test Failed");
	        if (result.getThrowable() != null) {
	            test.fail(result.getThrowable());
	        }

	        try {
	            String screenshotName = methodName + "_" + new JavaUtility().getSystemDateInFormat();
	            String path = new WebDriverUtility().takeScreenShot(AdminBaseClass.sDriver, screenshotName);
	            test.fail("Screenshot on failure",
	                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	        } catch (IOException e) {
	            test.log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
	        } catch (Exception e) {
	            test.log(Status.WARNING, "Unable to attach screenshot: " + e.getMessage());
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        ExtentTest test = getTest(result);
	        String methodName = result.getMethod().getMethodName();
	        test.log(Status.SKIP, methodName + " -> Test Skipped");
	        if (result.getThrowable() != null) {
	            test.log(Status.WARNING, result.getThrowable());
	        }
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        ExtentTest test = getTest(result);
	        test.log(Status.WARNING, result.getMethod().getMethodName()
	                + " -> Failed but within accepted success percentage");
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        onTestFailure(result);
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("--> Suite Execution Finished: " + context.getName() + " <--");
	        if (report != null) {
	            report.flush();
	        }
	        testMap.clear();
	    }

	    // Thread-safe key: combines result hashcode with thread id for parallel runs
	    private long getId(ITestResult result) {
	        return result.hashCode() + Thread.currentThread().getId() * 31L;
	    }

	    private ExtentTest getTest(ITestResult result) {
	        ExtentTest test = testMap.get(getId(result));
	        if (test == null) {
	            // Fallback safeguard in case mapping was missed (e.g. config method failure)
	            test = report.createTest(result.getMethod().getMethodName());
	            testMap.put(getId(result), test);
	        }
	        return test;
	    }
	}