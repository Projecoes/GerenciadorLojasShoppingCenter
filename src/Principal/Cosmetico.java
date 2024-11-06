package Principal;

public class Cosmetico extends Loja{
    private double taxaComercializacao;

    //construtor
    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
                     Data dataFundacao, int quantidadeMaximaProdutos, double taxaComercializacao) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaximaProdutos);
        this.taxaComercializacao = taxaComercializacao;
    }

    //Getter n setters
    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTaxa de Comercialização: " + taxaComercializacao;
    }
}