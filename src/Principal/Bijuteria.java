package Principal;

public class Bijuteria extends Loja{
    private double metaVendas;

    //construtor
    public Bijuteria(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao,  int quantidadeMaximaProdutos, double metaVendas) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaximaProdutos);
        this.metaVendas = metaVendas;
    }

    //Getters n setters
    public double getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nMeta de vendas: " + getMetaVendas();
    }
}
