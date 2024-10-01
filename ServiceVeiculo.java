import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo veiculo) throws Exception {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
                throw new Exception("Já existe um veículo cadastrado com esta placa!!");
            }
        }
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado!");
        } else {
            for (int i = 0; i < veiculos.size(); i++) {
                System.out.println("Veículo " + (i + 1) + " - " + veiculos.get(i));
            }
        }
    }

    public Veiculo pesquisarPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public void removerVeiculo(String placa) throws Exception {
        Veiculo veiculo = pesquisarPorPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            System.out.println("Veículo removido com sucesso!");
        } else {
            throw new Exception("Veículo não encontrado com a placa informada!");
        }
    }
}
