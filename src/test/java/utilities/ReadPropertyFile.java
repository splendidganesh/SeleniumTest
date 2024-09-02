package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public static void main(String[] args) throws IOException {

		
		FileReader fr = new FileReader("C:\\Users\\ISC\\Desktop\\Selenium\\src\\test\\resources\\configfile\\Config.properties");
		Properties p = new Properties();
		p.load(fr);

	}

}
