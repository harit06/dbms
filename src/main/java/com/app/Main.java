package com.app;

import com.app.wrapper.DatasetWrapper;
import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.*;

public class Main {

    // Update the file path of the input dataset
    public static final String INPUT_FILE_NAME = "C:\\Users\\welcome\\Downloads\\dataset.csv";
    public static final String OUTPUT_FILE_NAME = "C:\\Users\\welcome\\Downloads\\dataset-split-%d.csv";
    public static final int MERGE_SORT_BATCH_SIZE = 100000;

    public static final String SEARCH_WORD = "Sandman: Dream Hunters 30th Anniversary Edition";


    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
//        List<DatasetWrapper> datasetWrappers = csvRead();
//        List<DatasetWrapper> datasetWrappers = readCSV();
          List<DatasetWrapper> datasetWrappers = fileRead();

        int noOfFiles = (int) Math.ceil((double)datasetWrappers.size() / MERGE_SORT_BATCH_SIZE);
        for(int i = 1; i<= noOfFiles;i++) {
            writeToCSV(datasetWrappers, i);
        }

        DatasetWrapper[] sortedList = MergeSort.mergeSort(datasetWrappers.toArray(new DatasetWrapper[0]), 0, noOfFiles-1);

        Date startTime = new Date();
        // Linear Search
        int i = 0;
        for( ; i< sortedList.length;i++) {
            if(sortedList[i].getTitle().equals(SEARCH_WORD)) break;
        }

        if(i==sortedList.length) {
            System.out.println("Search Word not found");
        } else {
            System.out.println("Search Word found at position " + i);
        }

        long timeInNS= new Date().getTime()-startTime.getTime();
        System.out.println("Linear Search " + timeInNS + "ms");

        Map<String,List<DatasetWrapper>> hashTable = new HashMap<>();

        for( i = 0; i< sortedList.length;i++) {
            List<DatasetWrapper> l = hashTable.get(sortedList[i].getTitle());
            if (l == null) {
                l = new ArrayList<>();
                l.add(sortedList[i]);
                hashTable.put(sortedList[i].getTitle(), l);
            } else {
                l.add(sortedList[i]);
                hashTable.put(sortedList[i].getTitle(), l);
            }
        }

        // Hash Table Search
        startTime = new Date();
        List<DatasetWrapper> dwl = hashTable.get(SEARCH_WORD);
        timeInNS = new Date().getTime()-startTime.getTime();
        System.out.println("Hash Table Search " + timeInNS + "ms");

    }

    private static List<DatasetWrapper> readCSV() throws FileNotFoundException {
        Reader csvReader = new FileReader(INPUT_FILE_NAME);
        CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                .withType(DatasetWrapper.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        // Translate to Wrapper Bean
        List<DatasetWrapper> list = csvToBean.parse();
        return list;
    }

    private static void print(DatasetWrapper[] sortedList) {
        for(DatasetWrapper dw: sortedList) {
            System.out.println(dw.getTitle());
        }
    }

    private static void writeToCSV(List<DatasetWrapper> datasetWrappers, int i) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String fileName = String.format(OUTPUT_FILE_NAME,i);
        FileWriter writer = new FileWriter(fileName);
        StatefulBeanToCsvBuilder<DatasetWrapper> builder=
                new StatefulBeanToCsvBuilder(writer);
        StatefulBeanToCsv beanWriter =
                builder.withMappingStrategy(getDefaultMappingStrategyToWrite()).build();

        // Write list to StatefulBeanToCsv object
        int listStartingIndex = (i-1)*MERGE_SORT_BATCH_SIZE;
        int listEndingIndiex = listStartingIndex+MERGE_SORT_BATCH_SIZE;
        listEndingIndiex = listEndingIndiex > datasetWrappers.size() ? datasetWrappers.size(): listEndingIndiex;

        beanWriter.write(datasetWrappers.subList(listStartingIndex, listEndingIndiex));

        // closing the writer object
        writer.close();
    }

    private static MappingStrategy<DatasetWrapper> getDefaultMappingStrategyToWrite() {
        ColumnPositionMappingStrategy mappingStrategy=
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(DatasetWrapper.class);

        // Arrange column name as provided in below array.
        String[] columns = new String[]
                { "authors","bestsellersRank","categories","description","dimensionX","dimensionY","dimensionZ","edition","editionStatement","forAges","format","id","illustrationsNote","imageChecksum","imagePath","imageUrl","imprint","indexDate","isbn10","isbn13","lang","publicationDate","publicationPlace","ratingAvg","ratingCount","title","url","weight"
                };

        mappingStrategy.setColumnMapping(columns);
        return mappingStrategy;
    }

    private static List<DatasetWrapper> csvRead() throws FileNotFoundException {
        // Header to bean Map
        Map<String, String> headerMap = new
                HashMap<>();

        headerMap.put("authors", "authors");
        headerMap.put("bestsellers-rank", "bestsellersRank");
        headerMap.put("categories", "categories");
        headerMap.put("description", "description");
        headerMap.put("dimension-x", "dimensionX");
        headerMap.put("dimension-y", "dimensionY");
        headerMap.put("dimension-z", "dimensionZ");
        headerMap.put("edition", "edition");
        headerMap.put("edition-statement", "editionStatement");
        headerMap.put("for-ages", "forAges");
        headerMap.put("format", "format");
        headerMap.put("id", "id");
        headerMap.put("illustrations-note", "illustrationsNote");
        headerMap.put("image-checksum", "imageChecksum");
        headerMap.put("image-path", "imagePath");
        headerMap.put("image-url", "imageUrl");
        headerMap.put("imprint", "imprint");
        headerMap.put("index-date", "indexDate");
        headerMap.put("isbn10", "isbn10");
        headerMap.put("isbn13", "isbn13");
        headerMap.put("lang", "lang");
        headerMap.put("publication-date", "publicationDate");
        headerMap.put("publication-place", "publicationPlace");
        headerMap.put("rating-avg", "ratingAvg");
        headerMap.put("rating-count", "ratingCount");
        headerMap.put("title", "title");
        headerMap.put("url", "url");
        headerMap.put("weight", "weight");

        HeaderColumnNameTranslateMappingStrategy<DatasetWrapper> strategy =
                new HeaderColumnNameTranslateMappingStrategy<DatasetWrapper>();
        strategy.setType(DatasetWrapper.class);
        strategy.setColumnMapping(headerMap);

        // CSV Read
        CSVReader csvReader = new CSVReader(new FileReader(INPUT_FILE_NAME));
        CsvToBean csvToBean = new CsvToBean();
        csvToBean.setMappingStrategy(strategy);
        csvToBean.setCsvReader(csvReader);

        // Translate to Wrapper Bean
        List<DatasetWrapper> list = csvToBean.parse();
        return list;
    }


    private static List<DatasetWrapper> fileRead() throws IOException {
        // Reading the File
        CSVReader reader = new CSVReader(new FileReader(INPUT_FILE_NAME));
        String[] nextLine;

        // reads line by line
        int i = 0;

        // Ignore the header line
        reader.readNext();

        List<DatasetWrapper> inputList = new ArrayList<>();
        while ((nextLine = reader.readNext()) != null) {
            // There are some irregularities with JAVA CSV file reading where many of the records do not follow the csv format missing quotes are things like that.
            // Hence i am ignoring it. Please do consider this output as i tried different methods to import csv data and integrated it to my best of efforts
            if(nextLine.length < 27) {
                continue;
            }

            DatasetWrapper data = new DatasetWrapper();
            data.setAuthors(nextLine[0]);
            data.setBestSellersRank(nextLine[1]);
            data.setCategories(nextLine[2]);
            data.setDescription(nextLine[3]);
            data.setDimensionX(nextLine[4]);
            data.setDimensionY(nextLine[5]);
            data.setDimensionZ(nextLine[6]);
            data.setEdition(nextLine[7]);
            data.setEditionStatement(nextLine[8]);
            data.setForAges(nextLine[9]);
            data.setFormat(nextLine[10]);
            data.setId(nextLine[11]);
            data.setIllustrationsNote(nextLine[12]);
            data.setImageChecksum(nextLine[13]);
            data.setImagePath(nextLine[14]);
            data.setImageUrl(nextLine[15]);
            data.setImprint(nextLine[16]);
            data.setIndexDate(nextLine[17]);
            data.setIsbn10(nextLine[18]);
            data.setIsbn13(nextLine[19]);
            data.setLang(nextLine[20]);
            data.setPublicationDate(nextLine[21]);
            data.setPublicationPlace(nextLine[22]);
            data.setRatingAvg(nextLine[23]);
            data.setRatingCount(nextLine[24]);
            data.setTitle(nextLine[25]);
            data.setUrl(nextLine[26]);
            data.setWeight(nextLine[27]);

            // count the number of objects created
            i++;

            inputList.add(data);
        }

        System.out.println("Loaded " + i + " records as many of the are ignore due to format exceptions");
        System.out.println("Loaded " + inputList.size() + " records into memory");

        return inputList;
    }
}