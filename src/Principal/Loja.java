package Principal;

public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;


    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int quantidadeMaximaProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantidadeMaximaProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int quantidadeMaximaProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantidadeMaximaProdutos];
    }

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
    }

    public void imprimeProdutos(){
        for(Produto produto : estoqueProdutos){ //para cada produto em estoqueProdutos faça
            System.out.println(produto); //imprime os produtos da lista
        }
    }

    public boolean insereProduto(Produto produto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) { // Verifica a primeira posição nula
                estoqueProdutos[i] = produto;
                return true; // Produto inserido com sucesso
            }
        }
        return false; // Estoque cheio
    }

    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(nomeProduto)) { // Verifica o nome do produto
                estoqueProdutos[i] = null; // Remove o produto, tornando a posição nula
                return true; // Produto removido
            }
        }
        return false; //Produto nao encontrado
    }

    //calculo para gastos de salario
    public double gastosComSalario() {
        return salarioBaseFuncionario * quantidadeFuncionarios;
    }

    //verifica tamanho da loja
    public char tamanhoDaLoja() {
        if(quantidadeFuncionarios < 10) {
            return 'P';
        }else if(quantidadeFuncionarios <= 30){
            return 'M';
        }else {
            return 'G';
        }
    }

    //getters n setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantitadeDeFuncionarios) {
        this.quantidadeFuncionarios = quantitadeDeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                + "\nQuantidade de funcionário: " + getQuantidadeFuncionarios()
                + "\nSalário base dos funcionários:  " + getSalarioBaseFuncionario()
                + "\nEndereço: " + getEndereco()
                + "\nData da Fundação: " + dataFundacao;
    }
}