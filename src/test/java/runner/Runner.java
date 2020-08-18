package runner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {

        System.setProperty("Log4j.configurationFile", "./src/main/java/framework/config/log4j.xml");

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG tng = new TestNG();
        tng.addListener(tla);

        XmlSuite suite = new XmlSuite();
        suite.setName("Wildberries");

        List<String> files = new ArrayList<String>() {{
            add("./src/main/resources/wildberries.xml");
        }};
        suite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList();
        suites.add(suite);
        tng.setXmlSuites(suites);

        tng.run();
    }
}
