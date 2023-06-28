package cu.desoft.gtm.sigeml.comun.domain;

public class Nomenclador extends EntidadPersistente {
	public static String DEPARTAMENTO = "DEP";
	public static String CARGO = "CAR";
	
	private String value;
	private String descripcion;
	private String tipoNomenclador;
	private String keyWord;
	
	private Nomenclador padre;	
	
	public Nomenclador() {
		super();
	}

	@Override
	public String toString() {
		return ((value != null) ? value : "");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoNomenclador() {
		return tipoNomenclador;
	}

	public void setTipoNomenclador(String tipoNomenclador) {
		this.tipoNomenclador = tipoNomenclador;
	}
	
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Nomenclador getPadre() {
		return padre;
	}

	public void setPadre(Nomenclador padre) {
		this.padre = padre;
	}	
}
