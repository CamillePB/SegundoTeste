package segundoteste;

import java.util.ArrayList;

public class Segundo {
	private ArrayList<CandidatoEntity> Candidatos = new ArrayList<CandidatoEntity>();
	int codCandidato;
	String statusCandidato;

	public int gerarNumero() {
		return ++codCandidato;// incrementando um numero a cada registro
	}

	public String qualificado() {
		return statusCandidato = "Qualificado";
	}

	public String aprovado() {
		return statusCandidato = "Aprovado";
	}

	
	public void listarTodosAprovados() {// listar todos os candidatos aprovados

		for (var candidato : Candidatos) {
			if (candidato.getStatusCandidato() == "Aprovado")
				candidato.candidatoInfo();
		}

	}

	
	public void atualizarCandidato(int codCandidato, String statusCandidato) {// editar por status
		var candidato = buscarId(codCandidato);

		if (candidato != null) {
			candidato.atualizarCandidato(statusCandidato);
		}
	}

	
	public void listarPorId(int codCandidato) {// listar candidato por id
		var candidato = buscarId(codCandidato);

		if (candidato != null)
			candidato.candidatoInfo();
		else
			System.out.println("Candidato não foi encontrada");
	}

	
	public void registrarCandidato(CandidatoEntity candidatoEntity) {
		Candidatos.add(candidatoEntity);
		System.out.println("A inscrição de: " + candidatoEntity.getNomeCandidato() + " foi criada.\n");
	}

	
	public void desclassificarCandidato(int codCandidato) {// exclui candidato por id
		var candidato = buscarId(codCandidato);

		if (candidato != null) {
			if (Candidatos.remove(candidato))
				System.out.println("Candidato foi desclassificado\n");
			else
				System.out.println("A conta não foi encontrada");
		}
	}

	
	public CandidatoEntity buscarId(int codCandidato) {
		for (var candidato : Candidatos) {
			if (candidato.getCodCandidato() == codCandidato)
				return candidato;
		}

		return null;
	}
}
