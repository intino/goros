package io.intino.goros.builder.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
    private static final Integer BUFFER_SIZE = 8192;

    public ZipUtil() {
    }

    public static Boolean compress(ArrayList<String> aFiles, String sDestinationFilename) {
        BufferedInputStream oOrigin = null;

        try {
            FileOutputStream oDestination = new FileOutputStream(sDestinationFilename);
            ZipOutputStream oOutput = new ZipOutputStream(new BufferedOutputStream(oDestination));
            byte[] aData = new byte[BUFFER_SIZE];
            Iterator oIterator = aFiles.iterator();

            while(oIterator.hasNext()) {
                String sFilename = (String)oIterator.next();
                FileInputStream fisInput = new FileInputStream(sFilename);
                oOrigin = new BufferedInputStream(fisInput, BUFFER_SIZE);
                ZipEntry oEntry = new ZipEntry(sFilename);
                oOutput.putNextEntry(oEntry);

                int iCount;
                while((iCount = oOrigin.read(aData, 0, BUFFER_SIZE)) != -1) {
                    oOutput.write(aData, 0, iCount);
                }

                oOrigin.close();
            }

            oOutput.close();
            return true;
        } catch (Exception var11) {
            return false;
        }
    }

    public static Boolean decompress(String sFilename, String sDestination) {
        return decompress(new File(sFilename), sDestination);
    }

    public static Boolean decompress(InputStream inputStream, String destination) {
        try {
            BufferedOutputStream output = null;
            ZipInputStream input = new ZipInputStream(new BufferedInputStream(inputStream));
            byte[] aData = new byte[BUFFER_SIZE];

            ZipEntry oEntry;
            while((oEntry = input.getNextEntry()) != null) {
                if (oEntry.isDirectory()) {
                    (new File(destination + File.separator + oEntry.getName())).mkdirs();
                } else {
                    String sDestDN = FileUtil.getDirname(destination + File.separator + oEntry.getName());
                    String sDestFN = destination + File.separator + oEntry.getName();
                    (new File(sDestDN)).mkdirs();
                    FileOutputStream oOutput = new FileOutputStream(sDestFN);
                    output = new BufferedOutputStream(oOutput, BUFFER_SIZE);

                    int iCount;
                    while((iCount = input.read(aData, 0, BUFFER_SIZE)) != -1) {
                        output.write(aData, 0, iCount);
                    }

                    output.flush();
                    output.close();
                }
            }

            input.close();
            return true;
        } catch (Exception var11) {
            return false;
        }
    }

    public static Boolean decompress(File oFile, String sDestination) {
        try {
            return decompress(new FileInputStream(oFile), sDestination);
        } catch (Exception var11) {
            return false;
        }
    }
}
