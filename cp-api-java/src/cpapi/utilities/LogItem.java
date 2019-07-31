package cpapi.utilities;

public class LogItem {

	private String date = "";
	private String className = "";
	private String message = "";

	public LogItem(String log) {
		String[] l;
		try {
			l = log.split(";");
			date = l[0];
			className = l[1];
			message = l[2];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}