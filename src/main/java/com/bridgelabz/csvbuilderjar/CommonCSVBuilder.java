package com.bridgelabz.csvbuilderjar;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class CommonCSVBuilder implements ICSVBuilder
{
    /**
     * METHOD TO GET CSV CLASS ITERATOR
     * @param reader provides object of Reader to read the file
     * @param csvClass provides type of csv class
     * @param separator provides the separator for records in csv file
     * @return csvParser object
     * @throws CSVBuilderException while handling the occurred exception
     */
    @Override
    public Iterator getCSVFileIterator(Reader reader, Class csvClass, char separator)
            throws CSVBuilderException
    {
        return getCSVParser(reader, csvClass, separator).iterator();
    }

    @Override
    public List getCSVFileList(Reader reader, Class csvClass, char separator) throws CSVBuilderException
    {
        List list = null;
        try
        {
            list = getCSVParser(reader, csvClass, separator).getRecords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private CSVParser getCSVParser(Reader reader, Class csvClass, char separator) throws CSVBuilderException
    {
        try
        {
            CSVParser csvParser = new CSVParser(reader, CSVFormat
                    .DEFAULT.withDelimiter(separator)
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withIgnoreSurroundingSpaces(true));
            return csvParser;
        }
        catch (RuntimeException e)
        {
            throw new CSVBuilderException("Entered incorrect Delimiter or incorrect Header",
                    CSVBuilderException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
        }
        catch (IOException e)
        {
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.CSV_FILE_PROBLEM);
        }
    }
}