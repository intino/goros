package io.intino.goros.builder.util;

public class FileUtil {
    public FileUtil() {
    }

    public static String getBasename(String sFilename) {
        Integer iPos = sFilename.lastIndexOf(".");
        return iPos == -1 ? null : sFilename.substring(0, iPos);
    }

    public static String getDirname(String sFilename) {
        sFilename = StringUtil.replaceAll(sFilename, "\\", "/");
        Integer iPos = sFilename.lastIndexOf("/");
        return iPos == -1 ? null : sFilename.substring(0, iPos);
    }

    public static String getFilename(String sFilename) {
        sFilename = sFilename.replaceAll("\\\\", "/");
        Integer iPos = sFilename.lastIndexOf("/");
        return iPos == -1 ? sFilename : sFilename.substring(iPos + 1);
    }

    public static String getFilenameWithoutExtension(String sFilename) {
        sFilename = sFilename.replaceAll("\\\\", "/");
        Integer iPos = sFilename.lastIndexOf("/");
        int iDotPos = sFilename.lastIndexOf(".");
        return iPos == -1 ? null : sFilename.substring(iPos + 1, iDotPos);
    }

    public static String getExtension(String sFilename) {
        Integer iPos = sFilename.lastIndexOf(".");
        return iPos == -1 ? null : sFilename.substring(iPos + 1);
    }
}