package com.app;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        //        File myObj = new File(INPUT_FILE_NAME);
//        Scanner myReader = new Scanner(myObj);
//        List<String> l = new ArrayList<>();
//        myReader.nextLine();
//        while (myReader.hasNextLine()) {
//            String data = myReader.nextLine();
//            if(data.startsWith("\"["))
//                l.add(data);
//            else {
//                data = myReader.nextLine();
//                while(!data.startsWith("\"[")) {
//                    data = myReader.nextLine();
//                }
//                int lastIndx = l.size()-1;
//                l.remove(lastIndx);
//                l.add(data);
//            }
//        }
//        myReader.close();
//
//        FileWriter myWriter = new FileWriter("C:\\Users\\welcome\\Downloads\\data1.csv");
//        BufferedWriter info = new BufferedWriter(myWriter);
//
//        for(String d: l) {
//            info.write(d);
//            info.newLine();
//        }
//        myWriter.close();
    }
}
