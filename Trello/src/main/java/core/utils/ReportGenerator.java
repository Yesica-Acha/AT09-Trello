package core.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportGenerator {

    /**
     * Generates the report file for tests scenarios.
     */
    public static void generateReport() {
        File reportOutputDirectory = new File("build/cucumber");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("build/cucumber/cucumber.json");
        String projectName = "Trello";
        Configuration configuration =
                new Configuration(reportOutputDirectory, projectName);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        new ReportBuilder(jsonFiles, configuration).generateReports();
    }

}
