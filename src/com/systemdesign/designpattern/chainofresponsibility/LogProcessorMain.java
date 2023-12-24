package com.systemdesign.designpattern.chainofresponsibility;

public class LogProcessorMain {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null)));
        logProcessor.log(logProcessor.INFO, "This is info log");
        logProcessor.log(logProcessor.WARN, "This is warn log");
        logProcessor.log(logProcessor.ERROR, "This is error log");
    }
}

abstract class LogProcessor {
    int INFO = 0;
    int WARN = 1;
    int ERROR = 2;

    LogProcessor logProcessor;
    public LogProcessor(LogProcessor logProcessor){
        this.logProcessor = logProcessor;
    }

    void log(int level, String logMsg){
        if(logProcessor != null) logProcessor.log(level, logMsg);
        else System.out.println("No log processor present");
    }
}

class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    void log(int level, String logMsg){
        if(level == INFO) System.out.println("Info: "+logMsg);
        else logProcessor.log(level, logMsg);
    }
}

class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    void log(int level, String logMsg){
        if(level == ERROR) System.out.println("Error: "+logMsg);
        else logProcessor.log(level, logMsg);
    }
}

class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    void log(int level, String logMsg){
        if(level == WARN) System.out.println("Warn: "+logMsg);
        else logProcessor.log(level, logMsg);
    }
}

