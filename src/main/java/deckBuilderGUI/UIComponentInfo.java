package deckBuilderGUI;

public class UIComponentInfo {
	
	public enum UIType {
		INPUT, DROPDOWN, CHECKBOX;
	}
	
	private String name;
	private UIType type;
	private String[] selections;
	private int row;
	
	public UIComponentInfo(String name, UIType uitype, int row, String[] selections) {
		setName(name);
		setType(uitype);
		setRow(row);
		setSelections(selections);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public UIType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(UIType type) {
		this.type = type;
	}
	/**
	 * @return the selections
	 */
	public String[] getSelections() {
		return selections;
	}
	/**
	 * @param selections the selections to set
	 */
	public void setSelections(String[] selections) {
		this.selections = selections;
	}
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

}
