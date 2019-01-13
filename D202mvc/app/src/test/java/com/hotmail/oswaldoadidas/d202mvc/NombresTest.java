package com.hotmail.oswaldoadidas.d202mvc;

/**
 * Created by oswaldosaldivar on 13/04/16.
 *
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class NombresTest {

    @Test public void testNombres() {

        final Nombres nombres = new Nombres("Pp", "Qk");

        // Revisa que el objeto devuelva los valores recibidos en el constructor.

        assertEquals("Pp", nombres.getNombre1());

        assertEquals("Qk", nombres.getNombre2());

    }


}
