package Package_one;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import java.util.Vector ;



public class Apache_poi {

    public Apache_poi() {
    }

    public static Vector<Objects> run (String filepath) {
        int size = 0;
        int index = 0;
        char ch = 'a';
        Vector<String> cellValues;
        Vector<Objects> objects = new Vector<Objects>();
        Objects object;
        
        try {
            FileInputStream file = new FileInputStream(new File(filepath));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                int i = 0;
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                cellValues = API.getCellValues(row);
                size = cellValues.size();
                switch (cellValues.get(2).charAt(0)) {
                    case ('o'):
                        object = new Objects(cellValues.get(2), cellValues.get(0).charAt(0), cellValues.get(cellValues.size() - 1).charAt(0));
                        objects.add(object);
                        if (cellValues.get(1).length() > 8) {
                            ch = cellValues.get(1).charAt(cellValues.get(1).length() - 9);
                            index = (int) ch - '0';
                            index -= 1;
                            objects.get(index).objects.add(object);
                        }
                        break;

                    case ('s'):
                        if (cellValues.get(1).charAt(cellValues.get(1).length() - 2) != 'd') {
                            ch = cellValues.get(1).charAt(cellValues.get(1).length() - 9);
                            index = (int) ch - '0';
                            index -= 1;
                            objects.get(index).fields.add(new Fields(cellValues.get(1).substring(cellValues.get(1).length() - 7), cellValues.get(3)));
                        } else {
                            ch = cellValues.get(1).charAt(cellValues.get(1).length() - 8);
                            index = (int) ch - '0';
                            index -= 1;
                            objects.get(index).fields.add(new Fields(cellValues.get(1).substring(cellValues.get(1).length() - 6), cellValues.get(3)));
                        }
                        break;
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objects;
    }
}


