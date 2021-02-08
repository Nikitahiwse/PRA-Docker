package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

public class PRA_Base {
	String host = "localhost";
	static Properties prop;

	public static WebDriver wd;
	public static File folder;

	//to load data from property file
	public void load_property_file() throws IOException {
		prop = new Properties();

		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);

			InputStream input2 = getClass().getClassLoader().getResourceAsStream("mycabi.properties");
			prop.load(input2);


			InputStream input3 = getClass().getClassLoader().getResourceAsStream("By_pest.properties");
			prop.load(input3);

			InputStream input4 = getClass().getClassLoader().getResourceAsStream("ByPathway_Generation.properties");
			prop.load(input4);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//to get data from config property file
	public String getobject(String Data) throws IOException {
		load_property_file();
		String data = prop.getProperty(Data);
		return data;
	}
	/*
	 * //to load data from mycabi property file public static String
	 * getobject_for_mycabi(String Data2) throws IOException { load_property_file();
	 * String data2=prop2.getProperty(Data2); return data2; }
	 */

	//for browser opening
	public void initialzation(String url_name) throws InterruptedException, MalformedURLException {

		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		DesiredCapabilities dc;


//        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		//for chrome
/*
        ChromeOptions option = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", folder.getAbsolutePath());
        option.setExperimentalOption("prefs", prefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, option);
*/


		if (System.getProperty("BROWSER") != null &&
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();

		} else {
			dc = DesiredCapabilities.chrome();

		}

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String completeUrl = "http://" + host + ":4444/wd/hub";
		wd = new RemoteWebDriver(new URL(completeUrl), dc);

		System.out.println("URL NAME: " + url_name);
		//wd=new ChromeDriver(cap);
		wd.get(url_name);
	}

	//to close browser
	public void teardown() {

		wd.close();
		/*for (File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();*/

	}
}