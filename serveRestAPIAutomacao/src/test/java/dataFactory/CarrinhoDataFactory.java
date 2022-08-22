package dataFactory;

import pojo.CarrinhoPojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDataFactory {
    public static CarrinhoPojo cadastrarCarrinho() {
        CarrinhoPojo carrinho = new CarrinhoPojo();

        List<ProdutoPojo> produtos = new ArrayList<>();

        ProdutoPojo produto1 = new ProdutoPojo("Modial", 245, "Liquidificador", 11);
        ProdutoPojo produto2 = new ProdutoPojo("Electrolux", 2445, "Geladeira", 3);

        produtos.add(produto1);
        produtos.add(produto2);

        carrinho.setProdutos(produtos);

        return carrinho;
    }
}
