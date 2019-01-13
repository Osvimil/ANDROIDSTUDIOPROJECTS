package com.appspot.omagnoendpoints.endpointoswaldo;

/**
 * Created by oswaldosaldivar on 15/05/16.
 */

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.appspot.omagnoendpoints.proxyEndpointSaludo.ProxyEndpointSaludo;
import com.appspot.omagnoendpoints.proxyEndpointSaludo.model.Nombres;
import com.appspot.omagnoendpoints.proxyEndpointSaludo.model.Saludo;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;

public class FragmentSaludo extends Fragment {
    private static final boolean SERVIDOR_LOCAL = false;
    private static final String URL_LOCAL = "http://10.0.2.2:8080";
    private static final String URL_REMOTA = "https://omagnoendpoints.appspot.com";
    @SuppressWarnings("ConstantConditions")
    private static final String URL = SERVIDOR_LOCAL ? URL_LOCAL : URL_REMOTA;
    private static final String TAG = FragmentSaludo.class.getName();
    private static final String RAIZ_NULA = "Raíz nula.";
    private static final String VIEW_NO_ENCONTRADA =
            "View no encontrada en el archivo xml.";
    private static final String EXCEPTION_FALTA_NOMBRE =
            "com.appspot.omagnoendpoints.backend.ExceptionFaltaNombre";
    private static final String ESPERANDO_SALUDO = "Esperando saludo.";
    @Nullable private ProxyEndpointSaludo proxy;
    private AsyncTask<Nombres, Void, String> task;
    /**
     * Se invoca al añadir el fragment a la activity con el fragment manager. Si
     * el fragment declara en onActivityCreated que retiene su instancia, no se
     * destruye la instancia al rotar el dispositivo; en este caso, no se vuelve a
     * invocar este método.
     * @param savedInstanceState map que almacena el contenido guardado antes de
     * rotar el dispositivo. Las view que tienen asignado un id guardan
     * automáticamente su contenido en él.
     */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        proxy = creaProxyEndpointSaludo();
    }
    /**
     * Infla la vista al añadir el fragmento o rotar el dispositivo.
     * @param inflater inflador por utilizar.
     * @param container vista a la que se añade la vista del dispositivo.
     * @param savedInstanceState guarda los valores respaldados.
     * @return la vista asociada al fragment.
     */
    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_saludo, container, false);
    }
    /**
     * Se ejecuta una vez que la vista del fragment se ha creado.
     * @param view vista asociada al fragment.
     * @param savedInstanceState guarda los valores respaldados.
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button saludar = (Button) busca(R.id.saludar);
        saludar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                clicEnSaludar();
            }
        });
    }
    /**
     * Se invoca cuando el fragment y la activity a la que se agrega han sido
     * creados.
     * @param savedInstanceState guarda los valores respaldados.
     */
    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
// Permite que el fragmento se conserve al rotar el dispositivo.
        setRetainInstance(true);
    }
    AsyncTask<Nombres, Void, String> getTask() {
        return task;
    }
    @NonNull Button getSaludar() {
        return (Button) busca(R.id.saludar);
    }
    @NonNull TextView getSalida() {
        return (TextView) busca(R.id.salida);
    }
    public void clicEnSaludar() {
        if (proxy != null) {
            final Nombres modelo = new Nombres();
            modelo.setNombre1(recuperaTexto(R.id.nombre1));
            modelo.setNombre2(recuperaTexto(R.id.nombre2));
            task = new AsyncTask<Nombres, Void, String>() {
                /**
                 * Realiza en un hilo aparte la conexión al servidor.
                 * @param modelo la posición 0 contiene el modelo que se envía al
                 * servidor.
                 * @return la respuesta del servidor.
                 */
                @Override protected String doInBackground(Nombres... modelo) {
                    try {
                        final ProxyEndpointSaludo.Saluda saluda =
                                proxy.saluda(modelo[0]);
                        final Saludo saludo = saluda.execute();
                        return saludo.getTexto();
                    } catch (GoogleJsonResponseException e) {
                        return procesaError(e);
                    } catch (IOException e) {
                        return procesaError(e);
                    }
                }
                /**
                 * Se ejecuta en el hilo de la interfaz gráfica.
                 * @param respuesta valor devuelto por el servidor.
                 */
                @Override protected void onPostExecute(String respuesta) {
                    muestraRespuesta(respuesta);
                }
            };
            task.execute(modelo); // Empieza la ejecución de la tarea.
        }
    }
    @NonNull View busca(@IdRes int idView) {
        if (getView() == null) {
            throw new NullPointerException(RAIZ_NULA);
        } else {

            final View view = getView().findViewById(idView);
            if (view == null) {
                throw new NullPointerException(VIEW_NO_ENCONTRADA);
            } else {
                return view;
            }
        }
    }
    private void muestraRespuesta(@Nullable String respuesta) {
        if (isAdded()) {
            final TextView salida = (TextView) busca(R.id.salida);
            salida.setText(respuesta == null ? "" : respuesta);
        }
    }
    @NonNull private String recuperaTexto(@IdRes int idEditText) {
        final EditText editText = (EditText) busca(idEditText);
        return editText.getText().toString();
    }
    /**
     * Obtiene el mensaje de error del objeto de error y registra en bitácora si
     * no es un error de valdación.
     * @param e excepción que decribe el problema.
     * @return el texto que describe el error.
     */
    @NonNull private String procesaError(GoogleJsonResponseException e) {
        final String mensaje = getMessage(e);
        final String errorFaltaNombre =
                catchMensaje(EXCEPTION_FALTA_NOMBRE, mensaje);
        if (errorFaltaNombre == null) {
            Log.e(TAG, ESPERANDO_SALUDO, e);
            return mensaje;
        } else {
            return errorFaltaNombre;
        }
    }
    /**
     * Obtiene el mensaje de error del objeto de error y registra en bitácora.
     * @param e excepción que decribe el problema.
     * @return el texto que describe el error.
     */
    @NonNull private String procesaError(IOException e) {
        Log.e(TAG, ESPERANDO_SALUDO, e);
        return getIOExceptionMessage(e);
    }
    /**
     * Obtiene el mensaje de error para una excepción del tipo
     * GoogleJsonResponseException.
     * @param e excepción que se procesa.
     * @return mensaje asociado con la excepción.
     */
    @NonNull private String getMessage(GoogleJsonResponseException e) {
        final GoogleJsonError details = e.getDetails();
        return details == null || details.isEmpty() ? getIOExceptionMessage(e) :
                details.getMessage();
    }
/**
 * Obtiene el mensaje de error para una excepción del tipo IOException.
 * @param e excepción que se procesa.
 * @return mensaje asociado con la excepción.


 */
@NonNull private String getIOExceptionMessage(IOException e) {
    final String localizedMessage = e.getLocalizedMessage();
    return localizedMessage == null || localizedMessage.isEmpty() ?
            e.toString() : localizedMessage;
}
    /**
     * Si el mensaje empieza con el nombre de la excepción, devuelve el el texto
     * que sigue después. Si el texto no empieza con el nombre de la excepción,
     * devuelve null.
     * @param nombreException nombre de la excepción generada en el servidor.
     * @param texto mensaje recibido del servidor.
     * @return si el mensaje empieza con el nombre de la excepción, devuelve el el
     * texto que sigue después. Si el texto no empieza con el nombre de la
     * excepción devuelve null.
     */
    @Nullable private String catchMensaje(String nombreException, String texto) {
        final String busqueda = nombreException + ": ";
        if (texto.contains(busqueda)) {
            return texto.substring(busqueda.length());
        } else {
            return null;
        }
    }
    @NonNull private ProxyEndpointSaludo creaProxyEndpointSaludo() {
        final JacksonFactory jacksonFactory = new JacksonFactory();
        final HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();
        final HttpRequestInitializer httpRequestInitializer =
                new HttpRequestInitializer() {
                    @Override public void initialize(HttpRequest solicitudHttp)
                            throws IOException {
                    }
                };
        final ProxyEndpointSaludo.Builder builder =
                new ProxyEndpointSaludo.Builder(httpTransport, jacksonFactory,
                        httpRequestInitializer);
        builder.setApplicationName(getString(R.string.app_name));
        builder.setRootUrl(URL + "/_ah/api/");
// Solo se usa GZip al conectarse al servidor remoto.
        builder.setGoogleClientRequestInitializer(
                new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> request)
                            throws IOException {
                        if (SERVIDOR_LOCAL) {
                            request.setDisableGZipContent(true);
                        }
                    }
                });
        return builder.build();
    }
}