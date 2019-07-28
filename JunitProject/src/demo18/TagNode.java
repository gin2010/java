
package demo18;

import java.util.ArrayList;
import java.util.List;

public class TagNode {
	String name;
	public List<Attribute> attributes;
	public List<TagNode> children;
	String value;

	public TagNode(String name) {
		this.name = name;
		children = new ArrayList<TagNode>();
		attributes = new ArrayList<Attribute>();
	}

	public void add(TagNode childNode) {
		children.add(childNode);
	}

	public void addAttribute(String attribute, String value) {
		attributes.add(new Attribute(attribute, value));
	}

	public void addValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		TagPrinter result = new TagPrinter();
		writeMarkupTo(result);
		return result.toString();
	}
	
	public String getName() {
		return name;
	}

	public String getAttributeNamed(String key) {
		for (Attribute attribute : attributes)
			if (attribute.name().equals(key))
				return attribute.value();
		return null;
	}

	public String getValue() {
		if (hasValue())
			value = rightTrimmedValue();
		return value;
	}

	boolean hasValue() {
		return null != value && !value.equals("");
	}
	
	protected void writeMarkupTo(TagPrinter result) {
		writeOpenTagTo(result);
		writeValueTo(result);
		writeChildrenTo(result);
		writeCloseTagTo(result);
	}

	private String rightTrimmedValue() {
		return value.replaceAll("\\s+$", "");
	}

	private void writeCloseTagTo(TagPrinter result) {
		result.writeCloseTagFor(this);
	}

	private void writeOpenTagTo(TagPrinter result) {
		result.writeOpenTagFor(this);
	}

	private void writeChildrenTo(TagPrinter result) {
		result.writeChildrenFor(this);
	}

	private void writeValueTo(TagPrinter result) {
		result.writeValueFor(this);
	}
}
