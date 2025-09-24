package Com.OrangeHrm.Error;

public class InvalidBrowserError extends Error {

	private String browserName;

	public InvalidBrowserError(String browserName) {
		this.browserName = browserName;
	}

	@Override
	public String getMessage() {
		return "Invalid browser Name:" + this.browserName;
	}
}
