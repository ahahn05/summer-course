package com.example.project1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GridLoggerTest {
    @Test
    public void writeLn() {
        TestWriter writer = new TestWriter();
        GridLogger gridLogger = new GridLogger(writer);
        gridLogger.add("RobotX", "2.4");
        gridLogger.add("RobotY", "3.2");
        gridLogger.writeLn();
        gridLogger.add("RobotX","3.1");
        gridLogger.add("ignoreMe","foo");
        gridLogger.writeLn();


        List lines = writer.getLines();
        assertEquals("RobotX,RobotY",lines.get(0));
        assertEquals("2.4,3.2",lines.get(1));
        assertEquals("3.1,",lines.get(2));
        // check the lines
    }

    private class TestWriter implements LogWriter {

        List lines = new ArrayList();

        @Override
        public void writeLine(String line) {
            lines.add(line);
        }

        public List getLines() {
            return lines;
        }
    }



}