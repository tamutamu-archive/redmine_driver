package com.example.tools.redmine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConst {

    private static Properties prop = new Properties();

    static {
        InputStream inputStream;
        inputStream = AppConst.class.getResourceAsStream("/app.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String REDMINE_URL = prop.getProperty("redmine.url");
    public static String REDMINE_CUSTOM_FIELD_LIST_URL = REDMINE_URL + "/custom_fields";
    public static String REDMINE_CUSTOM_FIELD_NEW = REDMINE_URL + "/custom_fields/new";

    public static int CUSTOM_FIELD_SAVE_SLEEP = Integer.parseInt(prop.getProperty("custom.field.save.sleep"));

}
