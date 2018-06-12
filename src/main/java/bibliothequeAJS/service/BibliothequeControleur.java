package bibliothequeAJS.service;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliothequeAJS")
public class BibliothequeControleur {

	private List<Livre> livres;
	private Transfert transfert = new Transfert();

	@GetMapping(path = "/livres", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Livre> getLivres() {
		updateLivres();
		return livres;
	}

	@GetMapping(path = "/livres/{index}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public Livre getOccupation(@PathVariable("index") int index) {

		updateLivres();
		for (Livre livre : livres) {
			if (livre.getId() == index) {
				return livre;
			}
		}
		return null;
	}

	private void updateLivres() {
		livres = transfert.getLivres();

	}

	@PostMapping(path = "/transfert/{index}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	private String deleteLivre(@PathVariable("index") int index) {
		switch (transfert.deleteLivre(index)) {
		case Transfert.ERREUR_SQL:
			return "Probleme de base de donnee";

		case Transfert.LIVRE_ABSENT:
			return "Le livre n'existe pas";

		default:
			return "Retrait reussi";
		}

	}

}
