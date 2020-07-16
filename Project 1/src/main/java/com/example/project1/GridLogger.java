package com.example.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GridLogger {
    private LogWriter writer;
    private ArrayList<String> categories = new ArrayList<>();
    private HashSet<String> categorySet = new HashSet<>();
    private HashMap<String,String> dataRow = new HashMap<>();
    private boolean firstRow = true;



    public GridLogger(LogWriter writer) {
        this.writer = writer;
    }

    /**
     * Add a value to the logger under the category.  Categories are lazily added to the logger
     * in the order encountered.
     * @param category
     * @param value
     */
    public void add(String category, String value) {
        // If we haven't seen the category, add it to our list of categories
        // Add the category/value pair to our rowData HashMap
        if(!categorySet.contains(category)&&firstRow){
            categorySet.add(category);
            categories.add(category);
        }
        dataRow.put(category,value);
    }

    /**
     * Write a line of data to the log.  If this is the first call to writeLn, categories are
     * written first, followed by the line of data.  Once the data is written, the logger is reset
     * and calls to add() will add values to the next line of data.
     */
    public void writeLn() {
        //if its the first call to writeline then write the catergory headers
        if(firstRow){
            firstRow=false;
            StringBuffer s = new StringBuffer();
            for (int i = 0; i <categories.size() ; i++) {
                s.append(categories.get(i));
                if(i<categories.size()-1){
                    s.append(",");
                }

            }
            writer.writeLine(s.toString());
        }
        // wrte dataRow
        StringBuffer t = new StringBuffer();
        for (int i = 0; i < categories.size(); i++) {
            String cat = categories.get(i);
            String value = dataRow.get(cat);
            if(value==null){
                value = "";
            }
            t.append(value);
            if(i<categories.size()-1){
                t.append(",");
            }

        }
        writer.writeLine(t.toString());
        dataRow.clear();


    }

    public void stop() {}
}


