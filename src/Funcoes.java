import java.util.List;
import java.util.Scanner;

public class Funcoes {
  public static void menu() {
    System.out.println("Escolha uma das opções:");
    System.out.println("1. Criar nova conta");
    System.out.println("2. Sacar");
    System.out.println("3. Depositar");
    System.out.println("4. Transferir");
    System.out.println("5. Imprimir extrato");
    System.out.println("6. Sair");
  }

  public static int selecionaBanco(List<Banco> bancos) {
    Scanner scan = new Scanner(System.in);
    int index = 0;
    do {
      System.out.println("Escolha um dos bancos: ");
      for (int i = 0; i < bancos.size(); i++) {
        System.out.println("Banco " + i + " :");
        System.out.println(bancos.get(i).toString());

      }
      index = scan.nextInt();
    } while (index < 0 || index >= bancos.size());
    return index;
  }

  public static char selecionaTipoConta() {
    Scanner scan = new Scanner(System.in);
    int op;
    char tipoConta;
    do {
      System.out.println("Escolha uma das opções:");
      System.out.println("1. Conta poupança");
      System.out.println("2. Conta corrente");
      op = scan.nextInt();
    } while (op < 1 || op > 2);
    if (op == 1) {
      tipoConta = 'P';
    } else {
      tipoConta = 'C';
    }
    return tipoConta;
  }
}