package unedMasterSaludMapaSpring.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="countries")
public class country {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Column(name="country_name", nullable=false)
	 private String country_name;
	 @Column(name="country_code", nullable=false)
	 private String country_code;
	 
	 public country (){
		 
	 }	 
	
	
	public country(Long id, String country_name, String country_code) {
		super();
		this.id = id;
		this.country_name = country_name;
		this.country_code = country_code;
	}
	
	public country(String country_name, String country_code) {
		
		this.country_name = country_name;
		this.country_code = country_code;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCountry_name() {
		return country_name;
	}


	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}


	public String getCountry_code() {
		return country_code;
	}


	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}


	public String toString() {
		return "country [id=" + id + ", country_name=" + country_name + ", country_code=" + country_code + "]";
	}
	 

}
