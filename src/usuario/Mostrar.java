package usuario;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Natthaliee
 */

public class Mostrar {
    
    public static OkHttpClient webClient = new OkHttpClient();
    static Boolean res;
    
     public static Boolean ingresoUsuario(String us, String pass) throws IOException {
	URL url = new URL("http://localhost:5000/usuario/");
	Request peticion = new Request.Builder().url(url).build();
	Response respuesta = webClient.newCall(peticion).execute();
        String sRespuesta = respuesta.body().string();
	JSONArray arJSONUsuario = new JSONArray(sRespuesta);
	
        for (int i = 0; i < arJSONUsuario.length(); i++) {
            JSONObject usuario = arJSONUsuario.getJSONObject(i);
            if (us.equals(usuario.get("nombre"))&& pass.equals(usuario.get("pass"))){
                res = true;
            }else{
                res = false;
            }
        }
        return res;
    }

}
