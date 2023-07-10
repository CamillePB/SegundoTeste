package segundoteste;

public class CandidatoEntity {
	private int codCandidato;
	private String nomeCandidato;
	private String statusCandidato;
	
	public CandidatoEntity(int codCandidato, String nomeCandidato, String statusCandidato) {
		this.codCandidato = codCandidato;
		this.nomeCandidato = nomeCandidato;
		this.statusCandidato = statusCandidato;
	}

	public int getCodCandidato() {
		return codCandidato;
	}

	public void setCodCandidato(int codCandidato) {
		this.codCandidato = codCandidato;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public String getStatusCandidato() {
		return statusCandidato;
	}

	public void setStatusCandidato(String statusCandidato) {
		this.statusCandidato = statusCandidato;
	}
	
	public void atualizarCandidato(String statusCandidato) {
		this.setStatusCandidato(statusCandidato);
	}

	public void candidatoInfo() {

		System.out.println("\n     "+this.nomeCandidato);
		System.out.println("**************************************");
		System.out.println("id: " + this.codCandidato);
		System.out.println("status: " + this.statusCandidato+"");
		System.out.println("**************************************\n");
	}
}
