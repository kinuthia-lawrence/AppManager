package com.larrykin.appmanager.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdbConnector {

    private static final String ADB_PATH = "C:\\platform-tools\\adb"; // Full path to adb

    public static void main(String[] args) {
        AdbConnector connector = new AdbConnector();
        connector.getDeviceInfo();
    }

    public void getDeviceInfo() {
        try {
            // Execute adb shell commands
            String imei = executeAdbCommand("shell service call iphonesubinfo 1");
            String operator = executeAdbCommand("shell getprop gsm.operator.alpha");
            String signalQuality = executeAdbCommand("shell dumpsys telephony.registry | grep 'mSignalStrength'");

            System.out.println("IMEI: " + parseImei(imei));
            System.out.println("Operator: " + operator.trim());
            System.out.println("Signal Quality: " + signalQuality.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String executeAdbCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(ADB_PATH + " " + command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        reader.close();
        return output.toString();
    }

    private String parseImei(String output) {
        // The IMEI should be a 15-digit number
        Pattern pattern = Pattern.compile("\\b\\d{15}\\b");
        Matcher matcher = pattern.matcher(output);
        if (matcher.find()) {
            return matcher.group();
        }
        return "Unknown IMEI";
    }
}
/*

     The  getDeviceInfo()  method executes three adb shell commands to get the IMEI, operator name, and signal quality of the connected Android device. The  executeAdbCommand()  method executes the adb shell command and returns the output. The  parseImei()  method parses the IMEI from the output of the  dumpsys iphonesubinfo  command.
     To run this code, you need to have the adb tool installed on your computer. You can download the Android SDK platform tools from the  Android developer website.
     After downloading the platform tools, extract the contents to a folder on your computer. Update the  ADB_PATH  variable in the code with the full path to the adb executable.
     Run the code, and you should see the IMEI, operator name, and signal quality of the connected Android device printed to the console.
  */
