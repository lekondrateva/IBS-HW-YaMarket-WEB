package ru.ibs.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/scenario"},
        glue = {"ru.ibs.framework.steps"},
        tags = "@regress"
)
public class CucumberRunner {
}

