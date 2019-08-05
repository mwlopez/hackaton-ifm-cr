package cpapi.utilities;

public class RuntimeProcess {

    public static int run(String command, String arg1, String arg2) {
        int result;
        try {
            ProcessBuilder pb = new ProcessBuilder("/usr/bin/xvfb-run", "-a", command, arg1, arg2);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            p.waitFor();
            result = p.exitValue();
        } catch (Exception ex) {
            result = -1;
            Logger.logThis("ERROR RUNTIME " + ex.getMessage());
        }
        return result;
    }
}
