
package textExcel;


public class SpreadsheetLocation implements Location
{
	private String locate;

    public int getRow()
    {
        int rows = Integer.parseInt(locate.substring(1));
        return rows - 1;
    }

    public int getCol()
    {
        char column = locate.charAt(0);
        int cols = (int) column;
        //Implementation of ASCII table 
        return cols - 65;
    }
    
    
    public SpreadsheetLocation(String cellName)
    {
    	this.locate = cellName;
    }

}

