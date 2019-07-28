package demo18;

public class Attribute {
	private final String name;
	private String value;

	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String name() {
		return name;
	}

	public String value() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return " " + name + "=\"" + value + "\"";
	}
}
