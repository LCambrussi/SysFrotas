public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
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
        if (ano > 0) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido. Deve ser maior que 0.");
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
