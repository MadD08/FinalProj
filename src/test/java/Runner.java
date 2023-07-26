import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:/Users/Hedgehog/IdeaProjects/FinalProj/src/test/resources/features/BuyBook.feature"},
        glue = {"src/test/java/steps"}
)

public class Runner {

}
