package TestNGListeners;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.opencsv.CSVWriter;

import Utilities.ReportManager;

public class SuiteEvent extends TestListenerAdapter implements ISuiteListener, IExecutionListener, IReporter {
	CSVWriter writer;
	public List<String[]> data = new ArrayList<String[]>();

	@Override
	public void onFinish(ISuite arg0) {

	}

	@Override
	public void onStart(ISuite arg0) {

	}

	@Override
	public void onExecutionStart() {
		ReportManager.startReport();

	}

	@Override
	public void onExecutionFinish() {

		ReportManager.endReport();

	}

	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String outputDirectory) {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
		String dateStamp1 = new SimpleDateFormat("HH.mm.ss").format(new Date());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String csv = "./Reports/CSVReports/Bennett-"+timeStamp+".csv";

		try {
			writer = new CSVWriter(new FileWriter(csv));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (ISuite iSuite : arg1) {
			Map<String, ISuiteResult> results = iSuite.getResults();
			Set<String> keys = results.keySet();
			for (String key : keys) {
				ITestContext context = results.get(key).getTestContext();
				IResultMap resultMap = context.getFailedTests();

				// -------------------------FAILED TEST CASE-----------------------------
				Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();
				for (ITestNGMethod iTestNGMethod : failedMethods) {
					Date DateTime = new Date(iTestNGMethod.getDate());
					String dateDate = dateFormat.format(DateTime);
					String[] array_DataTime = dateDate.split(" ");
					data.add(new String[] {dateStamp, dateStamp1, iTestNGMethod.getMethodName(), iTestNGMethod.getDescription(), "FAIL"});
				}

				// -------------------------PASSED TEST CASE-----------------------------

				IResultMap resultMapPass = context.getPassedTests();
				Collection<ITestNGMethod> passMethods = resultMapPass.getAllMethods();
				for (ITestNGMethod iTestNGMethod : passMethods) {
					Date DateTime = new Date(iTestNGMethod.getDate());
					String dateDate = dateFormat.format(DateTime);
					String[] array_DataTime = dateDate.split(" ");
					data.add(new String[] {dateStamp, dateStamp1, iTestNGMethod.getMethodName(), iTestNGMethod.getDescription(), "PASS"});

				}

			}

		}
		String[] header = {"Date", "Time", "Test Case ID", "Description", "Result"};
		writer.writeNext(header);
		writer.writeAll(data);
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
