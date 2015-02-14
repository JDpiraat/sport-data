package be.johan40.enums;

public enum Activity {

	LOPEN("lopen"), FIETSEN("fietsen");

	private final String string;

	private Activity(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}
}
