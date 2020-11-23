package io.intino.goros.space;

import org.junit.Test;
import org.monet.services.SpaceService;
import org.monet.v3.Space;

public class BackServiceTest_ {
    private static String certificado ="C:/Desarrollo/fixing_fran/resources/businessunit-cctv.p12";
    private static String espacio = "http://fsantana.local.monentia.es/backservice";

    @Test
    public void should_openSpace() {
        org.monet.v3.Space v3 = (org.monet.v3.Space) SpaceService.openSpace(org.monet.v3.Space.VERSION, espacio, certificado, "1234");
    }
}
