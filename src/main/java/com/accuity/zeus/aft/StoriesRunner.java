package com.accuity.zeus.aft;

import com.accuity.zeus.aft.jbehave.steps.DetailsSteps;
import com.accuity.zeus.aft.jbehave.steps.SearchResultsSteps;
import com.accuity.zeus.aft.jbehave.steps.SearchSteps;
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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

    @Test
    public void run() throws IOException {
        List<String> storyPaths = new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("./src/main/resources"), "**/Currency.story", "");
        injectedEmbedder().runStoriesAsPaths(storyPaths) ;
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

}

