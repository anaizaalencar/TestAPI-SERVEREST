package pojo;

import java.util.List;

public class CarrinhoPojo {
    private List<ProdutoPojo> produtos;

    public CarrinhoPojo() {
    }

    public List<ProdutoPojo> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPojo> produtos) {
        this.produtos = produtos;
    }
}
