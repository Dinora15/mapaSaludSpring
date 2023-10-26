package unedMasterSaludMapaSpring.entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="datas")
public class Data {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Column(name="indicador_code", nullable=false)
	 private String indicador_code;
	 @Column(name="country_code", nullable=false)
	 private String country_code;
	 @Column(name="year", nullable=false)
	 private String year;
	 
	 
	 public Data() {
		 
	 }
	
	// Constructor con parámetros
	public Data(Long id, String indicador_code, String country_code, String year) {
		super();
		this.id = id;
		this.indicador_code = indicador_code;
		this.country_code = country_code;
		this.year=year;
	}

	// Constructor con parámetros (sin id)
	public Data(String indicador_code, String country_code, String year) {
		super();
		
		this.indicador_code = indicador_code;
		this.country_code = country_code;
		this.year=year;
	}

	// Métodos getter y setter para id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Métodos getter y setter para indicador_code
	public String getIndicador_code() {
		return indicador_code;
	}

	public void setIndicador_code(String indicador_code) {
		this.indicador_code = indicador_code;
	}

	 // Métodos getter y setter para country_code
	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	 // Métodos getter y setter para year
	public String getYear(){
		return year;
	}
	
	public void setYear(String year) {
		this.year=year;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", indicador_code=" + indicador_code + ", country_code=" + country_code + ", year="
				+ year + "]";
	}


}
