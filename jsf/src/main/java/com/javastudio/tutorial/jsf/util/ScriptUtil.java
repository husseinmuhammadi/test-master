package com.javastudio.tutorial.jsf.util;

public class ScriptUtil {
    public static String returnDialogBuilder(String url) {
        return "return " + dialogBuilder(url);
    }

    public static String dialogBuilder(String url) {
        return "openDialog('" + url + "');";
    }
}
