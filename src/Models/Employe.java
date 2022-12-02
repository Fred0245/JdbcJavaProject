package Models;

public class Employe {
	
	private int id;
	private String nom;
	private String email;
	private double salaire;
	
	public Employe(String nom, String email, double salaire) {
		this.nom = nom;
		this.email = email;
		this.salaire = salaire;
	}
	
	

	public Employe(int id, String nom, String email, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.salaire = salaire;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
	
	
	


}
