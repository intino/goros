package io.intino.goros.builder;

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
        Modernization modernization = Modernization.load(new File(args[0]));
        clear(new File(modernization.projectDirectory().getAbsolutePath() + "/../ui"));
        clear(modernization.projectDirectory());
        new GorosBuilder(modernization).compile();
    }

    private static void clear(File projectDirectory) throws IOException {
        if (!projectDirectory.exists()) return;
        Files.walk(projectDirectory.toPath()).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
    }

}