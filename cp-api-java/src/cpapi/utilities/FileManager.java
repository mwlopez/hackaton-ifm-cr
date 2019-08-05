package cpapi.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    /* TODO: Agregar separación de folders por fecha o por ID de cliente */

    private static final String APP_DATA = "data";
    private static final String APP_NAME = "cpapi";
    private static final String HTML_PATH = "html";
    private static final String LOG_PATH = "log";
    private static final String PDF_PATH = "pdf";
    private static final String QR_PATH = "qr";
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String UPLOAD_PATH = "upload";
    private static final String XML_PATH = "xml";

    public static String getHTMLPath() {
        return getHomePath() + APP_DATA + SEPARATOR + HTML_PATH + SEPARATOR;
    }

    private static String getHomePath() {
        return "/opt" + SEPARATOR + APP_NAME + SEPARATOR;
    }

    public static String getLogFromFile(String f) {
        return getStrFromFile(f);
    }

    public static String getLogPath() {
        return getHomePath() + APP_DATA + SEPARATOR + LOG_PATH + SEPARATOR;
    }

    public static String getPDFPath() {
        return getHomePath() + APP_DATA + SEPARATOR + PDF_PATH + SEPARATOR;
    }

    public static String getQRPath() {
        return getHomePath() + APP_DATA + SEPARATOR + QR_PATH + SEPARATOR;
    }

    public static String getStrFromFile(String f) {
        String result = null;
        try {
            result = new String(Files.readAllBytes(Paths.get(f)));
        } catch (Exception e) {
            Logger.logThis("FILE ERROR: " + e.getMessage());
        }
        return result;
    }

    public static String getUploadFromFile(String f) {
        String result = null;
        try {
            result = new String(Files.readAllBytes(Paths.get(getUploadPath() + f)));
        } catch (Exception e) {
            Logger.logThis("FILE ERROR: " + e.getMessage());
        }
        return result;
    }

    public static String getUploadPath() {
        return getHomePath() + APP_DATA + SEPARATOR + UPLOAD_PATH + SEPARATOR;
    }

    public static String getXMLPath() {
        return getHomePath() + APP_DATA + SEPARATOR + XML_PATH + SEPARATOR;
    }

    public static boolean writeFile(String file, String text) {
        boolean ok = true;
        try {
            File f = new File(file);
            // TODO: creo que no se ocupa f.getParentFile().mkdirs();
            if (!f.getParentFile().mkdirs()) {
                try (PrintWriter out = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(f, false)))) {
                    out.write(text);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            Logger.logThis("error escribiendo archivo");
            ok = false;
        }
        return ok;
    }
}
