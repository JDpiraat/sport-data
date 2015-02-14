package be.johan40.enums;

public enum Status {

	DEFAULT("default"), EENMALIG("eenmalig"), INKEUZELIJST("in keuzelijst");

	private final String string;

	private Status(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}
}
