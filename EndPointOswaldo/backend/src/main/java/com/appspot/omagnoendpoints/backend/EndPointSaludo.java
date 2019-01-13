/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.appspot.omagnoendpoints.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import static com.appspot.omagnoendpoints.backend.Constantes.FORMATO_DEL_SALUDO;
import static com.appspot.omagnoendpoints.backend.Constantes
        .MENSAJE_FALTA_EL_NOMBRE_1;
import static com.appspot.omagnoendpoints.backend.Constantes
        .MENSAJE_FALTA_EL_NOMBRE_2;
@Api(name = "proxyEndpointSaludo", version = "v1",
        namespace = @ApiNamespace(ownerDomain = "omagnoendpoints.appspot.com",
                ownerName = "omagnoendpoints.appspot.com", packagePath = ""))
public class EndPointSaludo {
    @ApiMethod(name = "saluda") public Saludo saluda(Nombres modelo)
            throws ExceptionFaltaNombre {
        valida(modelo.getNombre1(), MENSAJE_FALTA_EL_NOMBRE_1);
        valida(modelo.getNombre2(), MENSAJE_FALTA_EL_NOMBRE_2);
        final String saludo = construyeSaludo(modelo);
        return new Saludo(saludo);
    }
    private void valida(String nombre, String mensajeDeError)
            throws ExceptionFaltaNombre {
        if (nombre == null || nombre.isEmpty()) {
            throw new ExceptionFaltaNombre(mensajeDeError);
        }
    }
    private String construyeSaludo(Nombres modelo) {
        return String
                .format(FORMATO_DEL_SALUDO, modelo.getNombre1(), modelo.getNombre2());
    }
}
