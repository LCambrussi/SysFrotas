public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String marca, String modelo, int ano, String placa, int numeroPortas) {
        super(marca, modelo, ano, placa);
        setNumeroPortas(numeroPortas);
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        if (numeroPortas > 0 && numeroPortas <= 4) {
            this.numeroPortas = numeroPortas;
        } else {
            throw new IllegalArgumentException("Número de portas inválido. Deve estar entre 1 e 4.");
        }
    }

    @Override
    public String detalhesEspecificos() {
        return "N. Portas: " + numeroPortas;
    }

    @Override
    public String toString() {
        return "Tipo: Carro - " + super.toString() + " - " + detalhesEspecificos();
    }
}