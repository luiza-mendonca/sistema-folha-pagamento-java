package folhapagamento;

public class ColaboradorComissionado extends Colaborador {
    private double valorVendas;
    private double percentualComissao;

    public ColaboradorComissionado(String nome, double valorVendas, double percentualComissao) {
        super(nome, TipoColaborador.COMISSIONADO);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public double calcularComissao() {
        double comissao = valorVendas * percentualComissao / 100;
        return comissao;

    }

    @Override
    public double calcularSalarioFinal() {
        double salarioFinal = getSalarioBase() + calcularComissao();
        return salarioFinal;
    }

    @Override
    public String exibirDados() {
        return super.exibirDados() +
                "\nValor das vendas: R$ " + valorVendas +
                "\nPercentual da Comissão: " + percentualComissao + "%" +
                "\nValor da Comissão: R$ " + calcularComissao() +
                "\nValor Final do salário: R$ " + calcularSalarioFinal();
    }

}
