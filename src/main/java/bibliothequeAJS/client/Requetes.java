package bibliothequeAJS.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import bibliothequeAJS.service.Livre;

public class Requetes {
  URL url;
  HttpURLConnection connection;

  public Requetes() {
    try {
      url = new URL("http://192.168.1.19:8080/iaa-bibli/api/livre/id");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public String delete() throws Exception {

    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("DELETE");
    connection.setDoOutput(false);
    connection.setDoInput(true);

    System.out.println(connection.getContent());
    connection.getInputStream().close();
    return "code retour";
  }

  public List<Livre> get() throws IOException {

    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setDoOutput(false);
    connection.setDoInput(true);
    System.out.println(connection.getContent());
    connection.getInputStream().close();

    return new ArrayList<Livre>();
  }

}
