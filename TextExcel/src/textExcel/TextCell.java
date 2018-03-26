package textExcel;

public class TextCell implements Cell {

	private String strContent = "";
	
	public TextCell(String strContent){
		this.strContent = strContent;
	}

	public String abbreviatedCellText() {
		String abbreviatedText = "";
		char[] charArray = strContent.toCharArray();
		
		if(strContent.contains("\"")){
			for(int i = 1; i < strContent.length() - 1; i++){
				abbreviatedText += charArray[i];
			}
		}
		return (abbreviatedText + "          ").substring(0, 10);
	}

	public String fullCellText() {
		return strContent;
	}
	
}