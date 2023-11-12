package cbm.itic.m12.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {
	@Id                  //jakarta.persistence.Id
	private long id;

	@Column(nullable = false, unique = true)
	private String nom;

	@Column(nullable = false)
	private String cif;

	// A PARTIR D'AQUÍ CODI GENERAT DES DEL MENÚ "Source": 
	// Els 2 constructors i els getters i setters

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empresa(long id, String nom, String cif) {
		super();
		this.id = id;
		this.nom = nom;
		this.cif = cif;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	
}
