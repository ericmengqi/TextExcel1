package textExcel;

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int cols = 12;
	private Cell[][] arrayExcel = new Cell[20][12];
	
	public Spreadsheet(){
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; j++){
				arrayExcel[i][j] = new EmptyCell();
			}
		}
	} 

	public String processCommand(String command)
	{

		String[] commandSplit = command.split(" ");
		
		if(command.equals("")){
			return "";
		}else if(command.length() <= 3){
			return checkCell(commandSplit[0].toUpperCase());
		}else if(commandSplit.length >= 3){
			String input = commandSplit[2];
			for(int i = 3; i < commandSplit.length; i++){
				input += " " + commandSplit[i];
			}
			String cellName = commandSplit[0].toUpperCase();
			assignCell(input, cellName);
			return getGridText();
		}else if(commandSplit[0].toLowerCase().contains("clear")){
			if(commandSplit.length == 1){
				for(int i = 0; i < 20; i++){
					for(int j = 0; j < 12; j++){
						arrayExcel[i][j] = new EmptyCell();
					}
				}
				return getGridText();
			}else {
				clearOneCell(commandSplit[1].toUpperCase());
				return getGridText();
			}
		}
		return "";
	}

	public int getRows()
	{
		return this.rows;
	}

	public int getCols()
	{
		return this.cols;
	}

	public Cell getCell(Location loc)
	{
		return arrayExcel[loc.getRow()][loc.getCol()];
	}

	public String getGridText()
	{
		String gridText = "   |";
		
		for(char a = 'A'; a < 'M'; a++){
			gridText = gridText + a + "         |";
		}
		
		for(int i = 1; i <= rows; i++){
			
			gridText += "\n" + i;
			
			if(i < 10){
				gridText += "  |";
			}else if(i >= 10){
				gridText += " |";
			}
			for(int j = 0; j < cols; j++){
				gridText += arrayExcel[i-1][j].abbreviatedCellText() + "|";
			}
		}
		gridText += "\n";
		return gridText;
	}
	
	public void clearOneCell(String cellName){
		SpreadsheetLocation clearACell = new SpreadsheetLocation(cellName);
		arrayExcel[clearACell.getRow()][clearACell.getCol()] = new EmptyCell();
	}
	
	public void assignCell(String userInput, String cellName){
		SpreadsheetLocation cellAssign = new SpreadsheetLocation(cellName);
		arrayExcel[cellAssign.getRow()][cellAssign.getCol()] = new TextCell(userInput);
	}
	
	public String checkCell(String cellName){
		SpreadsheetLocation cellCheck = new SpreadsheetLocation(cellName); 
		return arrayExcel[cellCheck.getRow()][cellCheck.getCol()].fullCellText();
	}
	
	public void assignPercentCell(String userInput, String cellName){
		SpreadsheetLocation percentCellAssign = new SpreadsheetLocation(cellName);
		arrayExcel[percentCellAssign.getRow()][percentCellAssign.getCol()] = new PercentCell(userInput);
	}

}