package metlife.handlebars.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.common.base.Objects;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class HelloHelper {

    public String sayHello(String name) {
        return String.format("Hello %s!", Objects.firstNonNull(name, "unknown"));
    }
    
    
	public String readFileAsString() {
		BufferedReader br = null;
		FileReader fr = null;
		StringBuffer stringBuffer = new StringBuffer();

		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader("data.json");
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				stringBuffer.append(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		return stringBuffer.toString();
	}
}
