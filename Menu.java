package segundoteste;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Segundo sistemaRH = new Segundo();
		Scanner leia = new Scanner(System.in);
		boolean num = false;
		int opcao;
		int codCandidato;
		String nomeCandidato;

		// cadastro para teste
		CandidatoEntity candidato = new CandidatoEntity(sistemaRH.gerarNumero(), "João da Silva Azevedo", "Aprovado");
		sistemaRH.registrarCandidato(candidato);
		CandidatoEntity candidato2 = new CandidatoEntity(sistemaRH.gerarNumero(), "Ana da Silva Santos", "Recebido");
		sistemaRH.registrarCandidato(candidato2);

		while (true) {
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("       Sistema de RH - Controle de Candidatos        ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Registrar candidato                  ");
			System.out.println("            2 - Marcar entrevista para candidato     ");
			System.out.println("            3 - Desqualificar candidato              ");
			System.out.println("            4 - Verificar status do candidato        ");
			System.out.println("            5 - Aprovar candidato                    ");
			System.out.println("            6 - Listar candidatos aprovados          ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			// ler ações
			if (opcao > 6) {
				invalidMessage();
			} else if (opcao == 0) {// Finalizar sistema ao clicar em 0-Sair
				System.out.println("Operação Finalizada");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("Registrar candidato");
				System.out.println("Digite o Nome: ");

				if (leia.hasNextInt()) {
					leia.nextInt();// parar o case
					invalidMessage();
					break;

				} else {
					leia.skip("\\R?");
					nomeCandidato = leia.nextLine();

					sistemaRH.registrarCandidato(
							new CandidatoEntity(sistemaRH.gerarNumero(), nomeCandidato, "Recebido"));
				}

				keyPress();
				break;
			}

			case 2 -> {
				System.out.println("Marcar entrevista para candidato");
				System.out.println("0-Voltar\n");
				System.out.println("Digite o id do candidato: ");

				if (leia.hasNextInt()) {
					codCandidato = leia.nextInt();

					if (sistemaRH.buscarId(codCandidato) != null) {
						sistemaRH.listarPorId(codCandidato);

						enviar(num);

						if (!num) {
							sistemaRH.atualizarCandidato(codCandidato, sistemaRH.qualificado());
							System.out.println("Entrevista marcada com sucesso!\n");
						}
					} else if (codCandidato == 0) {
						break;
					} else {
						candidatoInexistente();
					}
				} else {
					invalidMessage();
					break;
				}

				keyPress();
				break;

			}

			case 3 -> {
				System.out.println("Desqualificar candidato");
				System.out.println("0-Voltar\n");
				System.out.println("Digite o id do candidato: ");

				if (leia.hasNextInt()) {
					codCandidato = leia.nextInt();
					if (sistemaRH.buscarId(codCandidato) != null) {
						sistemaRH.desclassificarCandidato(codCandidato);
					} else if (codCandidato == 0) {
						break;
					} else {
						candidatoInexistente();
					}
				} else {
					invalidMessage();
				}

				keyPress();
				break;
			}
			case 4 -> {
				System.out.println("Verificar status do candidato");
				System.out.println("0-Voltar\n");
				System.out.println("Digite o id do candidato: ");

				if (leia.hasNextInt()) {
					codCandidato = leia.nextInt();
					if (sistemaRH.buscarId(codCandidato) != null) {
						sistemaRH.listarPorId(codCandidato);
					} else if (codCandidato == 0) {
						break;
					} else {
						candidatoInexistente();
					}
				} else {
					invalidMessage();
				}

				keyPress();
				break;
			}

			case 5 -> {
				System.out.println("Aprovar candidato");
				System.out.println("0-Voltar\n");
				System.out.println("Digite o id do candidato: ");

				if (leia.hasNextInt()) {
					codCandidato = leia.nextInt();

					if (sistemaRH.buscarId(codCandidato) != null) {
						sistemaRH.listarPorId(codCandidato);

						enviar(num);

						if (!num) {
							sistemaRH.atualizarCandidato(codCandidato, sistemaRH.aprovado());
							System.out.println("Candidato aprovado com sucesso!\n");
						}

					} else if (codCandidato == 0) {
						break;
					} else {
						candidatoInexistente();
					}
				} else {
					invalidMessage();
				}

				keyPress();
				break;
			}

			case 6 -> {
				System.out.println("Listar candidatos aprovados");
				sistemaRH.listarTodosAprovados();
				keyPress();
				break;
			}

			}

		}

	}

	public static void keyPress() {// parar o menu até apertar enter
		try {
			System.out.println("Pressione a tecla enter para continuar");
			System.in.read();// tecla enter
		} catch (IOException e) {
			System.out.println("Erro de digitação");
		}
	}

	public static void enviar(boolean num) {// parar o menu até apertar enter
		try {
			System.out.println("Atenção!");
			System.out.println("Enter para CONFIRMAR alteração");
			System.in.read();// tecla enter
		} catch (IOException e) {
			System.out.println("Erro de digitação");
		}

		num = true;

	}

	public static void invalidMessage() {// mensagem de erro
		System.out.println("\nOpção Inválida! Tente novamente:\n");
	}

	public static void candidatoInexistente() {// mensagem de erro
		System.out.println("\nCandidato não foi encontrado!\n");
	}

	

}
