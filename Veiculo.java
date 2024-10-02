public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        setAno(ano);
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        String anoString = String.valueOf(ano);
        if (anoString.length() == 4) { 
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Ano inválido. Deve ter 4 dígitos.");
        }
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public abstract String detalhesEspecificos();

    @Override
    public String toString() {
        return "Marca: " + getMarca() + " - Modelo: " + getModelo() + " - Ano: " + getAno() + " - Placa: " + getPlaca();
    }
}
