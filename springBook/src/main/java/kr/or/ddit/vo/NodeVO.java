package kr.or.ddit.vo;

public class NodeVO {
	private String id;
	private String text;
	private String children;
	
	public NodeVO() {}

	@Override
	public String toString() {
		return "NodeVO [id=" + id + ", text=" + text + ", children=" + children + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}
	
	
}
