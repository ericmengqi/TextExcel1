package textExcel;

public abstract class RealCell implements Cell{
	
	private String userInput = "";
	
	public RealCell(String content){
		userInput = content;
	}
	
	public String abbreviatedCellText(){
		String abbreviatedText = "";
		char[] charArray = userInput.toCharArray();
		
		if(userInput.contains("\"")){
			for(int i = 1; i < userInput.length() - 1; i++){
				abbreviatedText += charArray[i];
			}
		}
		return (abbreviatedText + "          ").substring(0, 10);
	}
	
	public String fullCellText(){
		return userInput;
	}
	
	public abstract double getDoubleValue();
	
	public void setRealCell(String inputVal){
		userInput = inputVal;
	}

}