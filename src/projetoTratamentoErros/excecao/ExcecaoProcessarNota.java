package projetoTratamentoErros.excecao;

public class ExcecaoProcessarNota extends Exception{
	public ExcecaoProcessarNota(String erro) {
		super("Erro ao processar dados do aluno " + erro);
	}
}