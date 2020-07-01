package com.bridgelabz.csvbuilderjar;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;


public class OpenCSVBuilder implements ICSVBuilder
{
    /**
     * METHOD TO GET CSV CLASS ITERATOR
     * @param reader provides object of Reader to read the file
     * @param csvClass provides type of csv class
     * @param separator provides the separator for records in csv file
     * @return csvToBean object
     * @throws CSVBuilderException while handling the occurred exception
     */
    @Override
    public Iterator getCSVFileIterator(Reader reader, Class csvClass, char separator)
            throws CSVBuilderException
    {
        return getCSVBean(reader, csvClass, separator).iterator();
    }

    @Override
    public List getCSVFileList(Reader reader, Class csvClass, char separator) throws CSVBuilderException
    {
        return getCSVBean(reader, csvClass, separator).parse();
    }

    private CsvToBean getCSVBean(Reader reader, Class csvClass, char separator) throws CSVBuilderException
    {
        try
        {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(csvClass)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(separator)
                    .build();
            return csvToBean;
        }
        catch (RuntimeException e)
        {
            throw new CSVBuilderException("Entered incorrect Delimiter or incorrect Header",
                    CSVBuilderException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
        }
    }
}