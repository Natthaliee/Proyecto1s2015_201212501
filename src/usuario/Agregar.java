package usuario;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Natthaliee
 */
public class Agregar {
    
    public static OkHttpClient webClient = new OkHttpClient();
    
    public static void agregarUsuario(String nombre, String usuario, String pass, String direccion, String telefono, String tarjeta, String direccionactual) throws IOException {
        URL url = new URL("http://localhost:5000/usuario/agregar");

        RequestBody formBody = new FormEncodingBuilder()
            .add("nombre", nombre)
            .add("usuario", usuario)
            .add("pass", pass)
            .add("direccion", direccion)
            .add("telefono", telefono)
            .add("tarjeta", tarjeta)
            .add("direccionactual", direccionactual)            
            .build();

            Request request = new Request.Builder().url(url).post(formBody).build();

            Response respuesta = webClient.newCall(request).execute();
            System.out.println(respuesta.body().string());
    }
    
    public static void agregarOtro(String s1, String s2) throws IOException {
        URL url = new URL("http://localhost:5000/usuarios/agregar");

        RequestBody formBody = new FormEncodingBuilder()
            .add("name", s1)
            .add("model", s2)
            .build();

            Request request = new Request.Builder().url(url).post(formBody).build();

            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            System.out.println(response_string);
    }
}
