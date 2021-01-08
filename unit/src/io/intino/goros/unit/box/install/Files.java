package io.intino.goros.unit.box.install;

import io.intino.alexandria.logger.Logger;

import java.io.*;

public class Files {
  public static void saveReaderFile(Reader reader, File file) throws IOException {
    int intValueOfChar;
    StringBuilder buffer = new StringBuilder();
    while ((intValueOfChar = reader.read()) != -1) {
      buffer.append((char) intValueOfChar);
    }
    Writer targetFileWriter = new FileWriter(file);
    targetFileWriter.write(buffer.toString());
    targetFileWriter.close();
  }

  public static void makeDir(String dir) {
    Logger.info("Making dir: " + dir);
    File directory = new File(dir);

    if (!directory.exists())
      if (!directory.mkdirs()) {
        Logger.error("I can't create directory '" + dir + "'.");
      }
  }

  public static void replaceTextInFile(File file, String fromText, String toText) {
    String oldtext = "";
    try {
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line = "";

        StringBuilder buf = new StringBuilder();
        while ((line = reader.readLine()) != null) {
          buf.append(line + "\n");
        }
        oldtext = buf.toString();
      }

      String newtext = oldtext.replaceAll(fromText, toText);

      try (FileWriter writer = new FileWriter(file)) {
        writer.write(newtext);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
