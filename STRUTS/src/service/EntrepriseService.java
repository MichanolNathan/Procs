package service;

import java.util.ArrayList;
import java.util.List;
import domain.Entreprise;
import domain.EntrepriseDAO;


public class EntrepriseService {
	
	public EntrepriseService() {};
	
	EntrepriseDAO entrepriseDAO = new EntrepriseDAO();

	
	public String addEntreprise(Entreprise entreprise) {
		return this.entrepriseDAO.addEntreprise(entreprise);
	}
	
	public String editEntreprise(Entreprise entreprise) {
		return this.entrepriseDAO.editEntreprise(entreprise);
	}
	
	public Entreprise getEntreprise(int id) {
		return this.entrepriseDAO.getEntreprise(id);
	}
	
	public List <Entreprise> getEntreprises() {
		List <Entreprise> entreprises = new ArrayList<Entreprise>();
		entreprises = this.entrepriseDAO.getAllEntreprises();
		return entreprises;
	}
}
