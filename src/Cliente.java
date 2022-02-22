import java.util.ArrayList;
import java.util.List;

public class Cliente {

  private double cpf;
  private String nome;
  private List<ContaCorrente> contasCorrentes;
  private List<ContaPoupanca> contasPoupancas;

  public Cliente(double cpf, String nome) {
    this.cpf = cpf;
    this.nome = nome;
    this.contasCorrentes = new ArrayList<ContaCorrente>();
    this.contasPoupancas = new ArrayList<ContaPoupanca>();
  }

  public String getNome() {
    return nome;
  }

  public double getCpf() {
    return cpf;
  }

  public List<ContaCorrente> getContasCorrentes() {
    return contasCorrentes;
  }

  public List<ContaPoupanca> getContasPoupancas() {
    return contasPoupancas;
  }

}
