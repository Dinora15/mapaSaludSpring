package unedMasterSaludMapaSpring.entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="indicadores")
public class Indicador {

	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Column(name="indicador_code", nullable=false)
	 private String indicador_code;
	 @Column(name="indicador_name", nullable=false)
	 private String indicador_name;
	 @Column(name="source_nota", nullable=false)
	 private String source_nota;
	 @Column(name="source_organization", nullable=false)
	 private String source_organization;
	 
	 
	 public Indicador() {
		 
	 }


	public Indicador(Long id, String indicador_code, String indicador_name, String source_nota,
			String source_organization) {
		super();
		this.id = id;
		this.indicador_code = indicador_code;
		this.indicador_name = indicador_name;
		this.source_nota = source_nota;
		this.source_organization = source_organization;
	}
	 
	 public Indicador(String indicador_code, String indicador_name, String source_nota,
			String source_organization) {
		 this.indicador_code = indicador_code;
			this.indicador_name = indicador_name;
			this.source_nota = source_nota;
			this.source_organization = source_organization;
	 }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIndicador_code() {
		return indicador_code;
	}


	public void setIndicador_code(String indicador_code) {
		this.indicador_code = indicador_code;
	}


	public String getIndicador_name() {
		return indicador_name;
	}


	public void setIndicador_name(String indicador_name) {
		this.indicador_name = indicador_name;
	}


	public String getSource_nota() {
		return source_nota;
	}


	public void setSource_nota(String source_nota) {
		this.source_nota = source_nota;
	}


	public String getSource_organization() {
		return source_organization;
	}


	public void setSource_organization(String source_organization) {
		this.source_organization = source_organization;
	}


	@Override
	public String toString() {
		return "Indicador [id=" + id + ", indicador_code=" + indicador_code + ", indicador_name=" + indicador_name
				+ ", source_nota=" + source_nota + ", source_organization=" + source_organization + "]";
	}
	 
	 


}
