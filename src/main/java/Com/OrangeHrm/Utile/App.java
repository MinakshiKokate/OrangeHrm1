package Com.OrangeHrm.Utile;

public class App {
	private static String baseDir = System.getProperty("user.dir");
	private static String filepath = baseDir + "\\src\\main\\resources\\Properties\\App.Properties";

	public static String getAppUrl(String env) {
		return PropertiesUtile.getProperty(filepath, env + ".url");
	}

}
