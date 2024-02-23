package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {

    public static ProdutoPojo criarProdutoComumComOValorIgualA(double valor) {

        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("Play 4");
        produto.setProdutoValor(valor);


        List<String> cores = new ArrayList<>();
        cores.add("Preto");
        cores.add("Silver");


        produto.setProdutoCores(cores);

        produto.setProdutoURLMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo primeirocomponente=new ComponentePojo();
        primeirocomponente.setComponenteNome("controle");
        primeirocomponente.setComponenteQuantidade(1);

        componentes.add(primeirocomponente);

        produto.setComponentes(componentes);

        return produto;

    }


}
