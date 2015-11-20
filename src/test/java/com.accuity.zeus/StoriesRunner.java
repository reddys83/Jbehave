package com.accuity.zeus;

import com.accuity.zeus.aft.jbehave.steps.DetailsSteps;
import com.accuity.zeus.aft.jbehave.steps.SearchResultsSteps;
import com.accuity.zeus.aft.jbehave.steps.SearchSteps;
import com.accuity.zeus.utils.FilesUtils;
import org.apache.commons.io.FileUtils;
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.embedder.StoryRunner;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.google.common.collect.Lists.newArrayList;


@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(
        storyControls = StoriesRunner.MyStoryControls.class,
        storyLoader = StoriesRunner.MyStoryLoader.class,
        storyReporterBuilder = StoriesRunner.MyReportBuilder.class,
        parameterConverters = {StoriesRunner.MyDateConverter.class}
)
@UsingEmbedder(
        embedder = Embedder.class,
        generateViewAfterStories = true,
        ignoreFailureInStories = true,
        ignoreFailureInView = false,
        threads = 1,
        storyTimeoutInSecs = 15000,
        metaFilters = "-skip"
)
@UsingSteps(instances = {SearchSteps.class, SearchResultsSteps.class, DetailsSteps.class})
@UsingSpring(resources = {"classpath:/applicationContext.xml"})
public class StoriesRunner extends InjectableEmbedder {

    @Before
    public void loadXquery() {
        try {
            FileUtils.deleteDirectory(new File("C:\\Program Files\\MarkLogic\\Modules\\addn\\zeus"));
            File srcFolder = new File("./src/main/resources/xqueries");
            File destFolder = new File("C:\\Program Files\\MarkLogic\\Modules\\addn");
            FileUtils.copyDirectoryToDirectory(srcFolder, destFolder);
        } catch (IOException e) {
            System.out.println("The error message " + e.getMessage());
        }
    }


    @After
    public void styleReports() {
        try {
            File srcFolder = new File("./src/main/resources/reports");
            File destFolder = new File("./target/jbehave/view");
            if (destFolder.exists()) {
                try {
                    FilesUtils.copyFolder(srcFolder, destFolder);
                } catch (Exception e) {
                    System.out.println("The error message " + e.getMessage());
                }
            }
        } catch (Exception e) {
        }
    }

    @Test
    public void run() throws IOException {
        List<String> metaFiltersList = newArrayList(runASpecificStory().split(","));
        List<String> storyPaths = new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("./src/main/resources"), "**/*.story", "");
        injectedEmbedder().useMetaFilters(metaFiltersList);
        injectedEmbedder().runStoriesAsPaths(storyPaths) ;
    }

    private String runASpecificStory() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("environment.properties");
        properties.load(inputStream);
        if (System.getProperty("story") == null) {
            return properties.getProperty("web.aft.story.filter");
        } else {
            return System.getProperty("story");
        }
    }

    public static class MyStoryControls extends StoryControls {
        public MyStoryControls() {
            doDryRun(false);
            doSkipScenariosAfterFailure(false);
        }
    }

    public static class MyStoryLoader extends LoadFromClasspath {
        public MyStoryLoader() {
            super(StoryRunner.class.getClassLoader());
        }
    }

    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            this.withFormats(
                    org.jbehave.core.reporters.Format.STATS,
                    org.jbehave.core.reporters.Format.HTML,
                    org.jbehave.core.reporters.Format.XML,
                    org.jbehave.core.reporters.Format.CONSOLE
            ).withDefaultFormats();
        }
    }

    public static class MyDateConverter extends ParameterConverters.DateConverter {
        public MyDateConverter() {
            super(new SimpleDateFormat("yyyy-MM-dd"));
        }
    }

    private ArrayList getMetaFiltersList(String filterString){
        String[] metaFilter = filterString.split(",");
        ArrayList<String> metaFilterList = new ArrayList<String>();
        for (String item: metaFilter ){
            item = "+" + item;
            metaFilterList.add(item);
        }
        return metaFilterList;
    }

}

