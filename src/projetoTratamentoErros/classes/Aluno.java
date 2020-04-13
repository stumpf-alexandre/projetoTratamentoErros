package projetoTratamentoErros.classes;

import java.util.ArrayList;
import java.util.List;
import projetoTratamentoErros.constantes.StatusAluno;

public class Aluno {
	private String nome;
	private int idade;
	private String cpf;
	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Aluno() {
	}

	public Aluno(String nomePadrao, int idadePadrao) {
		nome = nomePadrao;
		idade = idadePadrao;
		
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/*metodo que retorna a media do aluno*/
	public double getMediaNota() {
		double somaNotas = 0.0;
		for(Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getNota1();
		}
		return somaNotas / disciplinas.size();
	}
	
	/*metodo que retorna true para aprovado ou false para reprovado*/
	public boolean getAlunoAprovado() {
		double media = this.getMediaNota();
		if(media >= 70) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*metodo que retorna uma string*/
	public String getAlunoAprovado2() {
		double media = this.getMediaNota();
		if(media >= 50) {
			if(media >= 70) {
				return StatusAluno.APROVADO;//"Aluno esta aprovado";
			}
			else {
				return StatusAluno.RECUPERACAO;//"Aluno esta em recuperação";
			}
		}
		else {
			return StatusAluno.REPROVADO;//"Aluno esta reprovado";
		}
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", disciplina=" + disciplinas
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}