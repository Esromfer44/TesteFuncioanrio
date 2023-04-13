package Trabalho.Atv03;

public class FuncionarioTerceirizado extends Funcionario {
    private double despesaAdicional;

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorHora, double despesaAdicional) {
        super(nome, horasTrabalhadas, valorHora);
        this.despesaAdicional = despesaAdicional;
    }

    @Override
    public double calculaPagamento() {
        double pagamento = super.calculaPagamento();
        double bonus = 0.0;
        if (despesaAdicional <= 1000.0) {
            bonus = despesaAdicional * 1.1;
        }
        pagamento += bonus;
        return pagamento;
    }

    // getters e setters para o atributo despesaAdicional
    public double getDespesaAdicional() {
        return despesaAdicional;
    }

    public void setDespesaAdicional(double despesaAdicional) {
        this.despesaAdicional = despesaAdicional;
    }
}