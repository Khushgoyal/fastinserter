package EPTFAssignment.solver;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration 
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			log.error("Json file path not provided.");
			System.exit(1);
		}
		String inFilePath = args[0];
		File inFile = new File(inFilePath);
		if (!inFile.exists()) {
			log.error("Json file does not exist. Provided Path:" + inFilePath);
			System.exit(2);
		}
		log.info("PATH:" + inFilePath);
		System.setProperty("inFilePath", inFilePath);
		if (inFile.length() / 1024 / 1024 / 1024 < 2)
			SpringApplication.run(Application.class, args);
		else {
			FasterSolution fs = new FasterSolution();
			fs.run(inFilePath);
		}
	}

}
