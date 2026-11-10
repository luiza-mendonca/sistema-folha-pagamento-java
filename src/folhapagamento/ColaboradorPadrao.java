package folhapagamento;

public class ColaboradorPadrao extends Colaborador {

    public ColaboradorPadrao(String nome) {
        super(nome, TipoColaborador.PADRAO);
    }

    @Override
    public String exibirDados() {
        return super.exibirDados() +
                "\nSalário final: R$ " + calcularSalarioFinal();
    }
}
