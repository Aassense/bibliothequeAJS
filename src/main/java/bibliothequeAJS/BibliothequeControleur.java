package bibliothequeAJS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BibliothequeControleur {

  private List<Livre> livres;

  @GetMapping(path = "/livres", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Livre> getLivres() {
    updateLivres();
    return livres;
  }

  @GetMapping(path = "/livres/{index}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Livre getOccupation(int index) {
    updateLivres();
    for (Livre livre : livres) {
      if (livre.getId() == index) {
        return livre;
      }
    }
    return null;
  }

  // met à jour la liste des livres depuis la base de données
  private void updateLivres() {
    livres = new ArrayList<Livre>();
    // TODO appel à la base
  }

}
