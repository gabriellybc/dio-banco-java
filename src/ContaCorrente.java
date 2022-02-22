public class ContaCorrente extends Conta {

  public ContaCorrente(Banco banco) {
    super(banco);
  }

  @Override
  public void imprimirExtrato() {
    System.out.println("=== Extrato Conta Corrente ===");
    super.imprimirInfosComuns();
  }

}