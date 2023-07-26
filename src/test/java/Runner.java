
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:/Users/Hedgehog/IdeaProjects/FinalProj/src/test/java/resources/BuyBook.feature"},
        glue = {"steps"}
)

public class Runner {

}
