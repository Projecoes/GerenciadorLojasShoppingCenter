package Principal;

import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    //construtor
    public Shopping(String nome, Endereco endereco,int capacidadeMaxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[capacidadeMaxLojas];
    }


    //metodo para adicionar lojas
    public boolean insereLoja(Loja loja){
        for (int i=0; i< lojas.length; i++){
            if (lojas[i] == null){
                lojas[i] =loja;
                return true; //loja inserida
            }
        }
        return false; //sem espaço
    }

    //metodo para remover loja
    public boolean removeLoja(String nomeLoja) {
        for(int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && nomeLoja.equals(lojas[i].getNome())) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    //metodo para verificar quantidade de lojas de tal tipo
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

    // esse metodo que percorre a lista de lojas, verifica se a loja é do tipo 'Informatica',
    // e retorna a loja com o maior valor de seguro eletrônico. Se não encontrar nenhuma
    // loja desse tipo, retorna null.
    public Informatica lojaSeguroMaisCaro() {
        Informatica informaticaAux = null;

        //para cada loja em lojas faça
        for (Loja loja : lojas) {
            // Usando instanceof com var para fazer o cast
            if (loja instanceof Informatica informatica) {

                // Atribui a primeira loja Informatica encontrada e compara com as demais
                if (informaticaAux == null || informatica.getSeguroEletronicos() > informaticaAux.getSeguroEletronicos()) {
                    informaticaAux = informatica;
                }
            }
        }
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
