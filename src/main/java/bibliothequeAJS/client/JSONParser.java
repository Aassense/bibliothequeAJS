package bibliothequeAJS.client;

import org.json.JSONObject;

import bibliothequeAJS.service.Livre;

public class JSONParser {
  public static void parse() {
    String jsonStr = "IAAliste.json";
    JSONObject json = new JSONObject(jsonStr);
    Livre livre = new Livre(0, jsonStr, 0, jsonStr, jsonStr);
    livre.setId(json.getInt("id"));
    livre.setTitre(json.getString("titre"));
    livre.setAnnee(json.getInt("annee"));
    livre.setAuteur(
        json.getString("prenom_auteur") + " " + json.getString("nom_auteur"));
    livre.setEditeur(json.getString("editeur"));
    System.out.println(livre.toString());
  }
}