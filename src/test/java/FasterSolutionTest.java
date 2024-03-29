import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import EPTFAssignment.solver.FasterSolution;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = FasterSolution.class)
public class FasterSolutionTest {

	@Autowired
	FasterSolution fs;

	@Test
	public void runfasterSolTest() throws Exception {
		fs.run("sample2.json");
	}
}