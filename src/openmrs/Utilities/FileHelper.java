package openmrs.Utilities;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.util.Preconditions.checkNotNull;


public class FileHelper {

    private static final Logger logger = LogManager.getLogger(FileHelper.class);

    /**
     * Private Constructor [Static Class].
     */
    private FileHelper() {
    }


    /**
     * Method to delete the desired file
     *
     * @param fileName desired file to delete
     */
    public static void deleteFile(String fileName) {
        try {
            //Specify the file name and path
            File file = new File(fileName);
            /*the delete() method returns true if the file is
             * deleted successfully else it returns false
             */
            if (file.delete()) {
                logger.info(file.getName() + " is deleted!");
            } else if (!file.exists()) {
                logger.info("File was deleted by the step definition");
            } else {
                logger.info("Delete failed: File didn't delete");
            }
        } catch (Exception e) {
            logger.info("File Exception occurred: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Method to get the File Extension
     *
     * @param fileName refers the desired file name
     * @return fileExtension
     */
    public static String getFileExtension(String fileName) {
        checkNotNull(fileName);
        String fileExtension = new File(fileName).getName();
        int dotIndex = fileExtension.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileExtension.substring(dotIndex + 1);
    }

    /**
     * Method to get the last header name from csv file
     *
     * @param fileName refers the desired csv file
     * @return return the last header name
     */
    public static String getLastHeaderNameFromCsv(String fileName) throws IOException {
        String lastHeaderValue = null;
        CSVParser csvParser = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            List<CSVRecord> csvRecords = csvParser.getRecords();
            for (int i = 0; i < csvRecords.size(); i++) {
                CSVRecord csvData = csvRecords.get(0);
                lastHeaderValue = (csvData.get(csvData.size() - 1));
                break;
            }
        } catch (Exception e) {
            logger.info("error found while reading file: " + e.getMessage());
        } finally {
            if (csvParser != null) {
                csvParser.close();
            }
        }
        return lastHeaderValue;
    }

    /**
     * Method to get a map of the specific row from csv file
     *
     * @param fileName  desired csv file
     * @param rowNumber desired row number
     * @return the Map of the desired row
     */
    public static List<String> getColumnValueFromCSV(String fileName, int rowNumber)
            throws IOException {
        List<String> rowValue = null;
        CSVParser csvParser = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            rowValue = new ArrayList<String>();
            Iterator<String> it = csvParser.getRecords().get(rowNumber).iterator();
            while (it.hasNext()) {
                rowValue.add(it.next());
            }
        } catch (Exception e) {
            logger.info("error found while reading file: " + e.getMessage());
        } finally {
            //close the file
            if (csvParser != null) {
                csvParser.close();
            }
        }
        return rowValue;
    }

    /**
     * Method to get a list of the specific column from csv file
     *
     * @param fileName   desired csv file
     * @param columnName desired column name
     * @return the list of values in the desired row
     */
    public static List<String> getAllColumnDataFromCSV(String fileName, String columnName)
            throws IOException {
        List<String> colValue = new ArrayList<>();
        CSVParser csvParser = null;

        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
            int columnIndex = csvParser.getHeaderMap().get(columnName);

            for (CSVRecord csvRecord : csvParser.getRecords()) {
                colValue.add(csvRecord.get(columnIndex));
            }
        } catch (Exception e) {
            logger.info("error found while reading file: " + e.getMessage());
        } finally {
            //close the file
            if (csvParser != null) {
                csvParser.close();
            }
        }
        return colValue;
    }


/*
    public static void readCsv() throws IOException
    {
        try(ICsvMapReader listReader = new CsvMapReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE))
        {
            //First Column is header names
            final String[] headers = listReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Map<String, Object> fieldsInCurrentRow;
            while ((fieldsInCurrentRow = listReader.read(headers, processors)) != null) {
                System.out.println(fieldsInCurrentRow);
            }
        }
    }
*/


    public static void getRowValue(String fileName) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(fileName));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String name = csvRecord.get(4);
                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
            }
        }
    }

    public static void getRowValue1(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

    }

    public static long getTheRecordNumberBasedOnRowValue(String fileName,String rowValue) throws IOException {
        CSVParser parser = new CSVParser(new FileReader(fileName),
                CSVFormat.DEFAULT.withHeader());
        long recordNumber = 0;

        for (CSVRecord record : parser) {
            if (record.get("Name*").equals(rowValue)) {
                recordNumber = record.getRecordNumber();
            }
        }
        parser.close();
        return recordNumber;
    }

    public static void getTheRowValue(String fileName,String rowValue) throws IOException {
        CSVParser parser = new CSVParser(new FileReader(fileName),
                CSVFormat.DEFAULT.withHeader());
        long recordNumber = 0;

        List<CSVRecord> result = new ArrayList<>();

        for (CSVRecord record : parser) {
            if (record.get("recordId").equals(rowValue)) {
                recordNumber = record.getRecordNumber();
            }

        }
        parser.close();
        //return recordNumber;
    }

    public static List<String> getDuplicateValue(List<String> duplicates){
        return duplicates.stream()
                .filter(string -> Collections.frequency(duplicates, string) > 1)
                .collect(Collectors.toList());
    }

}


