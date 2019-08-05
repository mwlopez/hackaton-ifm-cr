package cpapi.model;

public class OperationStatus {

	private String message = "";
	private boolean ok = true;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@Override
	public String toString() {
		return Boolean.toString(ok);
	}
}
