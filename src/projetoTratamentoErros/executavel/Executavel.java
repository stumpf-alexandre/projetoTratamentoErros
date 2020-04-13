package projetoTratamentoErros.executavel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import projetoTratamentoErros.classes.Aluno;
import projetoTratamentoErros.classes.Disciplina;
import projetoTratamentoErros.constantes.StatusAluno;
import projetoTratamentoErros.excecao.ExcecaoProcessarNota;

public class Executavel {
	public static void main(String[] args) {
		try {
			lerArquivo();
			
			/*try {*/ /*pucha a mensagem da classe exceção customisada*/
				/*File file = new File("lines.txt");
				Scanner scanner = new Scanner(file);
			} catch (FileNotFoundException e) {*/
				//throw new ExcecaoProcessarNota("Erro ao processar dados do aluno");
				/*throw new ExcecaoProcessarNota(e.getMessage());
			}*/
			
/*ERRO--->*//*File file = new File("lines.txt");
			Scanner scanner = new Scanner(file);*/
			
			String login = JOptionPane.showInputDialog("Informe o login");
			String senha = JOptionPane.showInputDialog("Informe a senha");
			
			if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
				
/*ERRO--->*/	List<Aluno> alunos = /*null*/ new ArrayList<Aluno>();
				
				HashMap<String/*valor da chave*/, List<Aluno>> maps = new HashMap<String, List<Aluno>>();//é uma lista que dentro dela temos uma chave que identifica uma sequencia de valores
				
				for(int qtd = 1; qtd <= 2; qtd++) {
					String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + " ? ");
					String idade = JOptionPane.showInputDialog("Qual a idade do aluno " + qtd + " ? ");
					String cpf = JOptionPane.showInputDialog("Qual o CPF do aluno " + qtd + " ? ");
					
					Aluno aluno4 = new Aluno();
					
					aluno4.setNome(nome);
					aluno4.setIdade(Integer.valueOf(idade));
					aluno4.setCpf(cpf);
					
					for (int pos = 1; pos <= 1; pos++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos +"? ");
						String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos +"? ");
						
						Disciplina disciplina = new Disciplina();
						disciplina.setNomeDisciplina(nomeDisciplina);
						disciplina.setNota1(Double.valueOf(notaDisciplina));
						
						aluno4.getDisciplinas().add(disciplina);
					}
					
					System.out.println("Nome = " + aluno4.getNome());
					System.out.println("Idade = " + aluno4.getIdade());
					System.out.println("CPF = " + aluno4.getCpf());
					System.out.println("Média do aluno é = " + aluno4.getMediaNota());
					System.out.println("Resultado = " + (aluno4.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
					System.out.println(aluno4.getAlunoAprovado2());
					
					System.out.println(aluno4.toString());/*demonstra os dados mais simplificado com toString*/
					
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina");
					
					if(escolha == 0) {
						int continuarRemovendo = 0;
						int posicao = 1;
						while(continuarRemovendo == 0) {
							String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3, 4 ?");
							aluno4.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
							posicao ++;
							continuarRemovendo = JOptionPane.showConfirmDialog(null, "Continuar a remover");
						}
					}
					alunos.add(aluno4);
				}
				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover algum aluno");
				
				if(escolha == 0) {
					int continuarRemovendo = 0;
					while(continuarRemovendo == 0) {
						String nome = JOptionPane.showInputDialog("Qual o nome do aluno para remover da lista? ");
						for (Aluno aluno : alunos) {
							if(aluno.getNome().equalsIgnoreCase(nome)) {//remove o aluno pela igualdade do nome
								alunos.remove(aluno);
								break;
							}
							else {
								System.out.println(aluno);/*descrição do objeto na memoria*/
								System.out.println("Média do aluno é = " + aluno.getMediaNota());
								System.out.println(aluno.getAlunoAprovado2());
								System.out.println("------------------------------------------------------------------------------");
							}
						}
						continuarRemovendo = JOptionPane.showConfirmDialog(null, "Continuar a remover");
					}
				}
				else {
					for (Aluno aluno : alunos) {
						System.out.println(aluno);/*descrição do objeto na memoria*/
						System.out.println("Média do aluno é = " + aluno.getMediaNota());
						System.out.println(aluno.getAlunoAprovado2());
						System.out.println("------------------------------------------------------------------------------");
					}
				}
				
				int substituicao = JOptionPane.showConfirmDialog(null, "Deseja substituir algum aluno");
				
				if(substituicao == 0) {
					int continuarSub = 0;
					while(continuarSub == 0) {
						String nome = JOptionPane.showInputDialog("Qual o nome do aluno para substituir da lista? ");
						for (int poss = 0; poss < alunos.size(); poss++) {
							Aluno aluno = alunos.get(poss);
							if(aluno.getNome().equalsIgnoreCase(nome)) {//substituir o aluno pela igualdade do nome e posição
								Aluno troca = new Aluno();
								String nomeSub = JOptionPane.showInputDialog("Qual o nome do aluno ? ");
								String idadeSub = JOptionPane.showInputDialog("Qual a idade do aluno ? ");
								String cpfSub = JOptionPane.showInputDialog("Qual o CPF do aluno ? ");
								troca.setNome(nomeSub);
								troca.setIdade(Integer.valueOf(idadeSub));
								troca.setCpf(cpfSub);
								for (int posSub = 1; posSub <= 4; posSub++) {
									String nomeDisciplinaSub = JOptionPane.showInputDialog("Nome da disciplina " + posSub +"? ");
									String notaDisciplinaSub = JOptionPane.showInputDialog("Nota da disciplina " + posSub +"? ");
									
									Disciplina disciplina = new Disciplina();
									disciplina.setNomeDisciplina(nomeDisciplinaSub);
									disciplina.setNota1(Double.valueOf(notaDisciplinaSub));
									
									troca.getDisciplinas().add(disciplina);
								}
								int escolhaSub = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina");
								
								if(escolhaSub == 0) {
									int continuarSubs = 0;
									int posicao = 1;
									while(continuarSubs == 0) {
										String disciplinaSubs = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3, 4 ?");
										aluno.getDisciplinas().remove(Integer.valueOf(disciplinaSubs).intValue() - posicao);
										posicao ++;
										//System.out.println(aluno4.toString());
										continuarSubs = JOptionPane.showConfirmDialog(null, "Continuar a remover");
									}
								}
								alunos.set(poss, troca);
								aluno = alunos.get(poss);
								break;
							}
							else {
								System.out.println(aluno);/*descrição do objeto na memoria*/
								System.out.println("Média do aluno é = " + aluno.getMediaNota());
								System.out.println(aluno.getAlunoAprovado2());
								System.out.println("------------------------------------------------------------------------------");
							}
						}
						continuarSub = JOptionPane.showConfirmDialog(null, "Continuar a substituir");
					}
				}
				else {
					for (Aluno aluno : alunos) {
						System.out.println(aluno);/*descrição do objeto na memoria*/
						System.out.println("Média do aluno é = " + aluno.getMediaNota());
						System.out.println(aluno.getAlunoAprovado2());
						System.out.println("------------------------------------------------------------------------------");
					}
				}
				
				for (Aluno aluno : alunos) {
					System.out.println("Alunos que sobraram na lista");
					System.out.println(aluno.getNome());
					System.out.println("Suas materias são");
					for (Disciplina disciplina : aluno.getDisciplinas()) {
						System.out.println(disciplina.getNomeDisciplina());
					}
				}
				
				for(int pos = 0; pos < alunos.size(); pos++) {//lista de alunos pela posição
					Aluno aluno = alunos.get(pos);
					System.out.println("Aluno : " + aluno.getNome());
					for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) {
						Disciplina disc = aluno.getDisciplinas().get(posd);
						System.out.println("Matéria : " + disc.getNomeDisciplina() + ", nota : " + disc.getNota1());
					}
					System.out.println("Media de " + aluno.getNome() + " : " + aluno.getMediaNota());
					System.out.println(aluno.getAlunoAprovado2());
					System.out.println("------------------------------------------------------------------------");
				}
				
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				
				for (Aluno aluno : alunos) {//lista de alunos aprovados, em recuperação e reprovados
					if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
					}
					else { 
						if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
							maps.get(StatusAluno.RECUPERACAO).add(aluno);
						}
						else {
							maps.get(StatusAluno.REPROVADO).add(aluno);
						}
					}
				}
				
				System.out.println("---------------Lista dos aprovados------------------");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)/*alunosAprovados*/) {
					System.out.println("Aluno " + aluno.getNome() + ", esta " + aluno.getAlunoAprovado2() + " com média de " + aluno.getMediaNota());
				}
				
				System.out.println("---------------Lista dos reprovados------------------");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)/*alunosReprovados*/) {
					System.out.println("Aluno " + aluno.getNome() + ", esta " + aluno.getAlunoAprovado2() + " com média de " + aluno.getMediaNota());
				}
				
				System.out.println("---------------Lista dos em recuperação------------------");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)/*alunosRecuperacao*/) {
					System.out.println("Aluno " + aluno.getNome() + ", esta em " + aluno.getAlunoAprovado2() + " com média de " + aluno.getMediaNota());
				}
			}
			else {
				System.out.println("Login ou Senha invalidos...");
			}
		/*}catch (Exception e) {
			StringBuilder saida = new StringBuilder();
			
			e.printStackTrace();//imprime erro no console java
			
			System.out.println("Mensagem: " + e.getMessage());//mensagem do erro ou causa*/
			
			/*for (int i = 0; i < e.getStackTrace().length; i++) {//mensagem de erro mais refinada
				System.out.println("Classe de erro: " + e.getStackTrace()[i].getClassName());
				System.out.println("Método de erro: " + e.getStackTrace()[i].getMethodName());
				System.out.println("Linha de erro: " + e.getStackTrace()[i].getLineNumber());
			}*/
			
			/*for (int i = 0; i < e.getStackTrace().length; i++) {
				saida.append("\n Classe de erro: " + e.getStackTrace()[i].getClassName());
				saida.append("\n Método de erro: " + e.getStackTrace()[i].getMethodName());
				saida.append("\n Linha de erro: " + e.getStackTrace()[i].getLineNumber());
				saida.append("\n Exceção de erro: " + e.getClass().getName());
			}*/
			
			/*JOptionPane.showMessageDialog(null, "Erro ao processar dados");*/ //mensagem de erro para usuario
			
			/*JOptionPane.showMessageDialog(null, "Erro ao processar dados" + saida.toString());*/
		}catch (NullPointerException e) {
			StringBuilder saida = new StringBuilder();
			
			for (int i = 0; i < e.getStackTrace().length; i++) {
				saida.append("\n Classe de erro: " + e.getStackTrace()[i].getClassName());
				saida.append("\n Método de erro: " + e.getStackTrace()[i].getMethodName());
				saida.append("\n Linha de erro: " + e.getStackTrace()[i].getLineNumber());
				saida.append("\n Exceção de erro: " + e.getClass().getName());
			}
			
			JOptionPane.showMessageDialog(null, "Erro ao processar dados" + saida.toString());
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro de conversão de número\n" + e.getClass().getName());
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro da exceção customizada: " + e.getClass().getName());
			
		/*}catch (ExcecaoProcessarNota e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro da exceção customizada: " + e.getClass().getName());*/
			
		}catch (Exception e) {
			e.printStackTrace(); //erro genérico captura todas as excessões que não prevemos
			JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getClass().getName());
		}finally {/*sempre é executado ocorrendo um erro ou não*/	
			JOptionPane.showMessageDialog(null, "Obrigado por aprender Java");
			/*aplicado para executar um processo mesmo ocorrendo erros ou não. Ex.: fechar a transação com o banco de dados*/
		}
	}
	
	/*public static void lerArquivo () throws ExcecaoProcessarNota{
		try {
			File file = new File("lines.txt");
			Scanner scanner = new Scanner(file);
		}catch (FileNotFoundException e) {
			throw new ExcecaoProcessarNota(e.getMessage());
		}
	}*/
	
	/*public static void lerArquivo () throws FileNotFoundException{
		try {
			File file = new File("lines.txt");
			Scanner scanner = new Scanner(file);
		}catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}*/
	
	public static void lerArquivo () throws FileNotFoundException{
		/*lança para cima e trabalha tudo em um try catch e centraliza as exceções*/
		File file = new File("lines.txt");
		Scanner scanner = new Scanner(file);
	}
}
