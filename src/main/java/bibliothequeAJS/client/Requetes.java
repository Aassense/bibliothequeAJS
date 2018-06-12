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
import org.springframework.beans.factory.annotation.Value;

import bibliothequeAJS.service.Livre;

/**
 * Consommation de l'API de bibliothèque
 *
 */
public class Requetes {
  URL url;
  HttpURLConnection connection;
  @Value("${api.delete.url: 'http://192.168.1.19:8080/iaa-bibli/api/livre/'}")
  private String deleteAPI;
  @Value("${api.get.url: 'http://192.168.1.19:8080/iaa-bibli/api/liste'}")
  private String getAPI;

  /**
   * requete HTTP DELETE pour supprimer un livre par l'API de iaa-bibli
   *
   * @param id
   *          identifiant du livre pris à la bibliothèque
   * @return le message donné par l'API
   * @throws IOException
   */
  public String delete(int id) throws IOException {
    url = new URL(deleteAPI + id);
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("DELETE");
    connection.setDoOutput(false);
    connection.setDoInput(true);

    // Récupération de la réponse de l'api
    BufferedReader br = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();

    // Conversion de la réponse en String
    JSONObject json = (JSONObject) JSONObject.stringToValue(sb.toString());
    json.getString("delete");

    connection.disconnect();
    return json.getString("delete");
  }

  /**
   * requete HTTP GET pour chercher l'ensemble des livres à travers l'API
   * iaa-bibli
   *
   * @return la liste des livres de la bibliothèque
   * @throws IOException
   */
  public List<Livre> getLivres() throws IOException {
    List<Livre> livres = new ArrayList<>();

    url = new URL(getAPI);
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
