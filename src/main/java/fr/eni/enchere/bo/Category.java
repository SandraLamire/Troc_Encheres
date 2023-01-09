package fr.eni.enchere.bo;
import java.io.Serializable;

public class Category implements Serializable {
    private int nbCategory;
    private String wording;

    public Category() {
    }
    
    public Category(int nbCategory, String wording) {
    	this.nbCategory = nbCategory;
    	this.wording = wording;
    }
    
    public int getNbCategory() {
    	return nbCategory;
    }
    
    public void setNbCategory(int nbCategory) {
		this.nbCategory = nbCategory;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + nbCategory + ", libelle=" + wording + "]";
	}

	
    
}