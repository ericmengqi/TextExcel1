
package textExcel;

public class PercentCell extends RealCell{
	
	private String userInput = "";
	
	public PercentCell(String userInput){
		super(userInput);
		setRealCell(userInput);
	}
	
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		return Double.parseDouble(userInput.substring(0, userInput.length() - 1)) / 100;
	}
	
	public String fullCellText(){
		return userInput;
	}

}