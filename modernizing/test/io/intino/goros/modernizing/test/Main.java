package io.intino.goros.modernizing.test;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.MonetModernizer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        args = Arrays.asList("/Users/mcaballero/Proyectos/externa/viasyobras/Modernizado/ejecucion/modernization.goros").toArray(new String[0]);
        Logger.info("Starting modernization with args " + String.join(",", args));
        if (args.length <= 0) {
            System.out.println("Path to modernization file not defined");
            return;
        }
        new MonetModernizer(Modernization.load(new File(args[0]))).compile();
    }

}
