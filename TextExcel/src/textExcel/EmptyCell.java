package textExcel;

//Class that returns empty cells

public class EmptyCell implements Cell {

	public EmptyCell(){
	}
	
	public String abbreviatedCellText() {
		return "          ";
	}

	public String fullCellText() {
		return "";
	}

}
