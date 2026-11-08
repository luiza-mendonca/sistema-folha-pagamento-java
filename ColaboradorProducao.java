package folhapagamento;

public class ColaboradorProducao extends Colaborador {
    private int quantidadePecas;
    private double valorPorPeca;

    public ColaboradorProducao(String nome, int quantidadePecas, double valorPorPeca) {
        super(nome, TipoColaborador.PRODUCAO);
        this.quantidadePecas = quantidadePecas;
        this.valorPorPeca = valorPorPeca;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }

    public double getValorPorPeca() {
        return valorPorPeca;
    }

    public void setQuantidadePecas(int quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }

    public void setValorPorPeca(double valorPorPeca) {
        this.valorPorPeca = valorPorPeca;
    }

    public double calcularProdutividade() {
        double produtividade = quantidadePecas * valorPorPeca;
        return produtividade;
    }

    @Override
    public double calcularSalarioFinal() {
        double salarioFinal = getSalarioBase() + calcularProdutividade();
        return salarioFinal;
    }

    @Override
    public String exibirDados() {
        return super.exibirDados() +
                "\nQuantidade de peças produzidas: " + getQuantidadePecas() +
                "\nValor por peça produzida: R$ " + getValorPorPeca() +
                "\nValor por produtividade: R$ " + calcularProdutividade() +
                "\nValor Final do salário: R$ " + calcularSalarioFinal();

    }

}
