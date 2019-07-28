
package demo18;

public class TagPrinter {
	private StringBuilder result = new StringBuilder("");

	protected void append(String contentToAppend) {
		result.append(contentToAppend);
	}

	protected void writeCloseTagFor(TagNode node) {
		if (!(node.children.size()>0 || node.hasValue())) 
			return;
		
		append("</");
		append(node.getName());
		append(">");
	}

	protected void writeOpenTagFor(TagNode node) {
		append("<");
		append(node.getName());
		for (Attribute attribute : node.attributes)
			append(attribute.toString());
		if (node.children.size()>0 || node.hasValue())
			append(">");
		else
			append("/>");
	}

	protected void writeValueFor(TagNode node) {
		if (node.hasValue())
			append(node.getValue());
	}

	protected void writeChildrenFor(TagNode parentNode) {
		for (TagNode node : parentNode.children)
			writeChildFor(node);
	}

	protected void writeChildFor(TagNode node) {
		node.writeMarkupTo(this);
	}
	
	public String toString() {
		return result.toString();
	}
}
