package com.bridgelabz.csvbuilderjar;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder
{
    public  Iterator getCSVFileIterator(Reader reader, Class csvClass, char separator)
            throws CSVBuilderException;
    public  List getCSVFileList(Reader reader, Class csvClass, char separator)
            throws CSVBuilderException;
}