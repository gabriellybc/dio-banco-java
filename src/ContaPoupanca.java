public class ContaPoupanca extends Conta {

  public ContaPoupanca(Banco banco) {
    super(banco);
  }

  @Override
  public void imprimirExtrato() {
    System.out.println("=== Extrato Conta Poupança ===");
    super.imprimirInfosComuns();
  }
}
