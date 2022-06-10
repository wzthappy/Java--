package Java.综合案例.黑马案例.util;

public class PathUtils {
    private static final String P_PATH = "C:\\Users\\86159\\IdeaProjects\\untitled\\src\\综合案例\\黑马案例\\images\\";

    public static String getRealPath(String relativePath) {
        return P_PATH + relativePath;
    }
}
