package com.larrykin.appmanager.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdbConnector {

    private static final String ADB_PATH_WINDOWS = "C:\\platform-tools\\adb"; // Full path to adb for Windows
    private static final String ADB_PATH_LINUX = "/usr/bin/adb"; // Updated path for Linux

    public static void main(String[] args) {
        AdbConnector connector = new AdbConnector();
        connector.printDeviceInfo();
    }

    public void printDeviceInfo() {
        try {
            // Execute adb shell commands
            String imeiOutput = executeAdbCommand("shell service call iphonesubinfo 1");
            String operator = executeAdbCommand("shell getprop gsm.operator.alpha");
            String signalQualityOutput = executeAdbCommand("shell dumpsys telephony.registry | grep -i 'signal'");
            String batteryLevel = getBatteryLevel();
            String phoneModel = getPhoneModel();

            String imei = parseImei(imeiOutput);
            String cleanedImei = extractAndCleanQuotedData(imeiOutput);

            // Parse signal strength from the output
            int signalLevel = parseSignalStrength(signalQualityOutput);
            String signalStatus = categorizeSignalLevel(signalLevel);

            // Print all collected information
            System.out.println("Phone Model: " + phoneModel);
            System.out.println("Cleaned IMEI: " + cleanedImei);
            System.out.println("Operator: " + operator.trim());
            System.out.println("Signal Quality: " + signalStatus);
            System.out.println("Battery Level: " + batteryLevel + "%");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String executeAdbCommand(String command) throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        String adbPath = os.contains("win") ? ADB_PATH_WINDOWS : ADB_PATH_LINUX;

        // Split the command into arguments
        String[] commandParts = command.split(" ");
        String[] fullCommand = new String[commandParts.length + 1];
        fullCommand[0] = adbPath;
        System.arraycopy(commandParts, 0, fullCommand, 1, commandParts.length);

        ProcessBuilder processBuilder = new ProcessBuilder(fullCommand);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        reader.close();
        process.waitFor();
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

    private String extractAndCleanQuotedData(String text) {
        // Regex to extract data within single quotes
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            // Remove non-numeric characters and spaces
            String cleaned = matcher.group(1).replaceAll("[^0-9]", "");
            result.append(cleaned);
        }

        return result.toString();
    }

    private String getBatteryLevel() {
        String batteryLevel = "Not Found";
        try {
            String adbOutput = executeAdbCommand("shell dumpsys battery");
            batteryLevel = parseBatteryLevel(adbOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batteryLevel;
    }

    private String parseBatteryLevel(String adbOutput) {
        String batteryLevel = "Not Found";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ProcessBuilder("adb", "shell", "dumpsys", "battery").start().getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("level:")) {
                    String[] parts = line.split(":");
                    batteryLevel = parts[1].trim();
                    break; // Exit loop once battery level is found
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batteryLevel;
    }

    private int parseSignalStrength(String adbOutput) {
        int level = 0; // Default to no signal
        String regex = "lteLevel=(\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(adbOutput);

        if (matcher.find()) {
            String levelStr = matcher.group(1);
            try {
                level = Integer.parseInt(levelStr.trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return level;
    }

    private String categorizeSignalLevel(int level) {
        switch (level) {
            case 4:
                return "Excellent";
            case 3:
                return "Fair";
            case 2:
                return "Low";
            case 1:
                return "Very Low";
            default:
                return "No Signal";
        }
    }

    private String getPhoneModel() {
        String model = "Unknown Model";
        try {
            String adbOutput = executeAdbCommand("shell getprop ro.product.model");
            model = adbOutput.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}

/*

     The  getDeviceInfo()  method executes five adb shell commands to get the Model, IMEI, operator name,signal quality and battery of the connected Android device. The  executeAdbCommand()  method executes the adb shell command and returns the output. The  parseImei()  method parses the IMEI from the output of the  dumpsys iphonesubinfo  command.
     To run this code, you need to have the adb tool installed on your computer. You can download the Android SDK platform tools from the  Android developer website.
     After downloading the platform tools, extract the contents to a folder on your computer. Update the  ADB_PATH  variable in the code with the full path to the adb executable.
     Run the code, and you should see the IMEI, operator name, and signal quality of the connected Android device printed to the console.
  */