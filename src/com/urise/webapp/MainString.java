package com.urise.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] StringArray = new String[] {"1", "2", "3"};
//        String result = "";
        StringBuilder sb = new StringBuilder();
        for (String str:StringArray) {
            sb.append(str).append(",");
        }
        System.out.println(sb.toString());
    }
}
