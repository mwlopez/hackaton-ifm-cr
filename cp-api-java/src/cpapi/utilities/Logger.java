package cpapi.utilities;

import java.io.*;
import java.util.ArrayList;

public class Logger {

    public static final String APP_NAME = "cpapi";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static ArrayList<LogItem> getTodayLog(int maxRecords) {
        ArrayList<LogItem> log = null;
        String logContents;
        try {
            log = new ArrayList<>();
            logContents = FileManager.getLogFromFile(getTodayLogPath());
            LogItem l;
            String line;
            if (logContents != null && !logContents.isEmpty()) {
                int count = 0;
                BufferedReader reader = new BufferedReader(new StringReader(logContents));
                while ((line = reader.readLine()) != null) {
                    l = new LogItem(line);
                    log.add(l);
                    count++;
                    if (count > maxRecords) {
                        log.remove(0);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }

    private static String getTodayLogPath() {
        return FileManager.getLogPath() + APP_NAME + "-" + Common.getDateStr() + "-log.txt";
    }

    public static void logThis(Object object, String message, Exception exception) {
        if (message == null) message = "";
        if (exception != null) {
            logThis(object, message + " [EX] " + exception.getMessage());
        } else {
            if (!message.isEmpty())
                logThis(object, message);
        }
    }

    public static void logThis(Object o, String message) {
        String time = Common.getDateTimeStr();
        String output;
        try {
            String file = getTodayLogPath();
            File f = new File(file);
            if (!f.getParentFile().mkdirs()) {
                try (PrintWriter out = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(f, true)))) {
                    if (o != null) {
                        output = time + ";" + o.getClass().toString() + ";" + message;
                    } else {
                        output = time + ";-;" + message;
                    }
                    System.out.println(output);
                    out.write(output + LINE_SEPARATOR);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("[ERROR LOG] " + e.getMessage());
        }
    }

    public static void logThis(String message) {
        logThis(null, message);
    }
}
