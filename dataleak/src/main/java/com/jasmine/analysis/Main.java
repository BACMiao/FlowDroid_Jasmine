package com.jasmine.analysis;

import com.jasmine.analysis.config.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;

import java.io.File;
import java.io.IOException;


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        //Load the path information in source.json file.
        Constant.loadConstant();

        //SetUpApplication implements a common interface that supports all data flow analysis of taint wrappers.
        SetUpApplication application = new SetUpApplication();

        //Create and set up a taint wrapper
        File taintWrapperFile = new File("/Users/jasmine/FlowDroidPlus/soot-infoflow/EasyTaintWrapperSource.txt");
        application.setTaintWrapper((new EasyTaintWrapper(taintWrapperFile)));

        //The main part of the program
        application.runInfoflow("/Users/jasmine/FlowDroidPlus/soot-infoflow-android/SourcesAndSinks.txt");
    }
}
