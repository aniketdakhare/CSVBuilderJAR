package com.bridgelabz.csvbuilderjar;

public class CSVBuilderFactory
{
    /**
     * METHOD TO CREATE OBJECT OF OpenCSVBuilder
     * @return object of OpenCSVBuilder
     */
    public static ICSVBuilder createCSVBuilder(int select)
    {
        ICSVBuilder builder = null;
        switch (select)
        {
            case 0:
                builder = new OpenCSVBuilder();
                break;
            case 1:
                builder = new CommonCSVBuilder();
                break;
        }
        return builder;
    }
}