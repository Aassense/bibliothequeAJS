package bibliothequeAJS.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import bibliothequeAJS.service.Livre;

public class Requetes {
  URL url;
  HttpURLConnection connection;

  public String delete() throws Exception {
    url = new URL("http://192.168.1.19:8080/iaa-bibli/api/livre/id");
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("DELETE");
    connection.setDoOutput(false);
    connection.setDoInput(true);
    System.out.println(connection.getContent());
    connection.getInputStream().close();
    return "code retour";
  }

  public List<Livre> get() throws IOException {
    List<Livre> livres = new ArrayList<>();

    url = new URL("http://192.168.1.19:8080/iaa-bibli/api/liste");
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setDoOutput(false);
    connection.setDoInput(true);
    BufferedReader br = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();
    JSONArray jsonArray = new JSONArray(sb.toString());

    for (int i = 0; i < jsonArray.length(); i++) {

      JSONObject json = jsonArray.getJSONObject(i);
      livres.add(new Livre(json.getInt("id"), json.getString("titre"),
          json.getInt("annee"),
          json.getString("prenom_auteur") + " " + json.getString("nom_auteur"),
          json.getString("editeur")));
    }
    connection.disconnect();

    return livres;
  }

}
