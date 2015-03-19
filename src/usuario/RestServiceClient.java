package usuario;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;
 
/**
* @author Natthaliee
*
*/
public class RestServiceClient {
    
    public static void main(String[] args) {
        String s = "";
        try {
            InputStream crunchifyInputStream = new FileInputStream("C:/Users/Natthaliee/Desktop/JSONFile.txt");
            InputStreamReader crunchifyReader = new InputStreamReader(crunchifyInputStream);
            BufferedReader br = new BufferedReader(crunchifyReader);
            String line;
            while ((line = br.readLine()) != null) {
                s += line + "\n";
            }
 
            JSONObject jsonObject = new JSONObject(s);
            System.out.println(jsonObject);
 
            executeRESTSevice(jsonObject, "http://localhost:5000/todo/api/v1.0/tasks");
 
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String executeRESTSevice(JSONObject objetoJSON, String URL) throws Exception {
            
        
        try {
                URL url = new URL(URL);
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(objetoJSON.toString());
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                
                System.out.println("\nllamada servicio REST exitoso");
                in.close();
            } catch (Exception e) {
                System.out.println("\nError al invocar el servicio REST");
                System.out.println(e);
            }            
        return null;
        }

}