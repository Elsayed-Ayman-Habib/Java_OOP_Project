package Package_one;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextArea;

import javafx.stage.FileChooser;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;


import java.io.File;
import java.util.Vector ;

import java.io.FileInputStream;

public class Controller {
    private Vector<Objects> objects = new Vector<Objects>();

private int current =1;
    @FXML
    private Button next;

    @FXML
    private Button openBtn;

    @FXML
    private TextArea obj1H = new TextArea();

    @FXML
    private TextArea obj1t = new TextArea();


    @FXML
    private void Open(ActionEvent event) throws IOException {



        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);


        String filePath = selectedFile.getAbsolutePath();
        FileInputStream file = new FileInputStream(new File(filePath));

       //  Create Workbook instance holding reference to .xlsx file
         XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

         objects = Apache_poi.run(filePath);

        StringBuilder str = new StringBuilder();

            obj1H.setText(objects.get(0).name);

            for(int j = 0 ; j < objects.get(0).fields.size() ; j++){

                str.append(objects.get(0).fields.get(j).name);
                str.append('\n');

            }

            for(int j = 0 ; j < objects.get(0).objects.size() ; j++){

                str.append(objects.get(0).objects.get(j).name);
                str.append('\n');
            }
            obj1t.setText(str.toString());

    }
    @FXML

    public void next () {
        if (current < objects.size()) {
            StringBuilder str = new StringBuilder();

            obj1H.setText(objects.get(current).name);

            for (int j = 0; j < objects.get(current).fields.size(); j++) {

                str.append(objects.get(current).fields.get(j).name);
                str.append('\n');
            }
            for (int j = 0; j < objects.get(current).objects.size(); j++) {

                str.append(objects.get(current).objects.get(j).name);
                str.append('\n');
            }
            obj1t.setText(str.toString());
            current++;
        }
        else
        {
            obj1H.setText("Done");
            obj1t.setText("Done");
        }
    }
}