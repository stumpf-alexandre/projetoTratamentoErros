package projetoTratamentoErros.classes;

public class Disciplina {
	private String nomeDisciplina;
	private double nota1;
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public double getNota1() {
		return nota1;
	}
	
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nota1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Disciplina other = (Disciplina) obj;
		if (nomeDisciplina == null) {
			if (other.nomeDisciplina != null)
				return false;
		} else if (!nomeDisciplina.equals(other.nomeDisciplina))
			return false;
		if (Double.doubleToLongBits(nota1) != Double.doubleToLongBits(other.nota1))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [nomeDisciplina=" + nomeDisciplina + ", notaDisciplina=" + nota1 + "]";
	}
}