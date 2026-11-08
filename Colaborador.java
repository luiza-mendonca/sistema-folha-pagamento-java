package folhapagamento;

public class Colaborador {
    private static int proximaMatricula = 1;
    private final int matricula;
    private String nome;
    private static final double SALARIO_BASE = 2000.00;
    private final TipoColaborador tipoColaborador;

    public Colaborador(String nome, TipoColaborador tipoColaborador) {
        this.matricula = proximaMatricula++;
        this.nome = nome;
        this.tipoColaborador = tipoColaborador;
    }

    public int getMatricula() {
        return matricula;
    }

    public TipoColaborador getTipoColaborador() {
        return tipoColaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return SALARIO_BASE;
    }

    public double calcularSalarioFinal() {
        return SALARIO_BASE;
    }

    public String exibirDados() {
        return "Matrícula: " + matricula +
                "\nNome: " + nome +
                "\nSalário base: R$ " + SALARIO_BASE +
                "\nTipo de Colaborador: " + tipoColaborador;
    }
}
