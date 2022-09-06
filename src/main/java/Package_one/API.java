package Package_one;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.Iterator;

import java.util.Vector ;

public class API
{
    /*data field*/
    private static Vector<String> cellValues;

    public API() {
    }

    public static void setCellValues(Vector<String> cellValues) {
        API.cellValues = cellValues;
    }

    /*method*/
    static Vector<String> getCellValues(Row row)
    {
        cellValues = new Vector<String>();
        //For each row, iterate through all the columns
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext())
        {
            org.apache.poi.ss.usermodel.Cell cell = cellIterator.next();
            //Check the cell type and format accordingly
            cellValues.add(cell.getStringCellValue());
        }
        return cellValues;
    }
}
