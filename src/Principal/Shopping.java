package Principal;

import java.util.Arrays;

import static java.util.Objects.isNull;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;


    public Shopping(String nome, Endereco endereco,int capacidadeMaxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[capacidadeMaxLojas];
    }


    public boolean insereLoja(Loja loja){
        for (int i=0; i< lojas.length; i++){
            if (lojas[i] == null){
                lojas[i] =loja;
                return true; //loja inserida
            }
        }
        return false; //sem espaço
    }

    public boolean removeLoja(String nomeLoja) {
        for(int i = 0; i < lojas.length; i++) {
            if(nomeLoja.equals(lojas[i].getNome())) {
                lojas[i] = new Loja();
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja){
        //verifica se o parâmetro passado condiz com os tipos de loja no shopping
        if (!tipoLoja.equals("Cosmético") && !tipoLoja.equals("Vestuário") &&
                !tipoLoja.equals("Bijuteria") && !tipoLoja.equals("Alimentação") &&
                !tipoLoja.equals("Informática")) {
            return -1; // retorna -1 se for diferente dos tipos de loja disponíveis no shopping
        }
        int contador = 0;
        for (Loja loja : lojas) { // Para cada loja em lojas[] faça
            if (loja != null && tipoLoja.equals(loja.getNome())) {
                contador++; // Incrementa o contador se a loja do tipo correspondente for encontrada
            }
        }

        return contador; // Retorna a quantidade de lojas do tipo especificado
    }

    public Informatica lojaSeguroMaisCaro() {
        //Inicializa uma variável auxiliar para armazenar a loja de informática com o maior seguro
        Informatica informaticaAux = null;
        // Inicializa uma variável para a loja atual sendo analisada
        Informatica informatica = null;
        for (Loja loja : lojas) {
            //verifica se a loja atual é uma instância da classe informatica
            if (loja instanceof Informatica) {
                //faz o cast da loja para o tipo informatica
                informatica = (Informatica) loja;
                // Se informaticaAux é null (não foi inicializado), atribui a primeira loja Informatica
                if (isNull(informaticaAux)) informaticaAux = informatica;
                // Se o seguro da loja atual é maior que o da loja com maior seguro encontrado, atualiza informaticaAux
                if (informatica.getSeguroEletronicos() > informaticaAux.getSeguroEletronicos()) {
                    informaticaAux = informatica;
                }
            }
        }
        // Retorna a loja Informatica com o maior seguro, ou null se não encontrar nenhuma loja desse tipo
        return informaticaAux;
    }


    //getters n setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", lojas=" + Arrays.toString(lojas) +
                '}';
    }
}
