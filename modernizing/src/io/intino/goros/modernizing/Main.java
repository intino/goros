package io.intino.goros.modernizing;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.MonetModernizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        args = Arrays.asList("./temp/modernization.goros").toArray(new String[0]);
        if (args.length <= 0) {
            System.out.println("Path to modernization file not defined");
            return;
        }
        new MonetModernizer(Modernization.load(new File(args[0]))).compile();
    }

    private static void clear(File projectDirectory) throws IOException {
        if (!projectDirectory.exists()) return;
        Files.walk(projectDirectory.toPath()).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
    }

}
