import java.util.Scanner;

public abstract class Conta {

  private static final int AGENCIA_PADRAO = 1;
  private static int SEQUENCIAL = 1;

  protected int agencia;
  protected int numero;
  protected double saldo;
  protected Banco banco;

  public Conta(Banco banco) {
    this.agencia = Conta.AGENCIA_PADRAO;
    this.numero = SEQUENCIAL++;
    this.banco = banco;
  }

  public void sacar() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Você tem atualmente: R$ " + saldo + " reais");
    System.out.println("Informe o valor que deseja sacar: ");
    double valor = scan.nextDouble();
    if ((saldo - valor) < 0) {
      System.out.println("Saldo insuficiente para a operação!");
      return;
    }
    saldo -= valor;
    System.out.println("Depois do saque você ficou com R$ " + saldo + " reais");
  }

  public void depositar() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Você tem atualmente: R$ " + saldo + " reais");
    System.out.println("Informe o valor que deseja depositar: ");
    double valor = scan.nextDouble();
    saldo += valor;
    System.out.println("Depois do deposito você ficou com R$ " + saldo + " reais");

  }

  public int getAgencia() {
    return agencia;
  }

  public int getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }

  protected void imprimirInfosComuns() {
    System.out.printf("Banco: %s\n", this.banco.getNome());
    System.out.printf("Agencia: %d\n", this.agencia);
    System.out.printf("Numero: %d\n", this.numero);
    System.out.printf("Saldo: %.2f\n", this.saldo);
  }

  protected abstract void imprimirExtrato();

  public Banco getBanco() {
    return banco;
  }
}