import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Gabrielly Barcelos Cariman
 */

public class Main {
    public static void main(String[] args) {
        List<Cliente> todosClientes = new ArrayList<Cliente>();

        List<Banco> bancos = new ArrayList<Banco>();
        Banco brasil, caixa, inter, itau, c6, nu;
        brasil = new Banco(001, "Banco do Brasil S.A.");
        bancos.add(brasil);
        caixa = new Banco(104, "Caixa Econômica Federal");
        bancos.add(caixa);
        inter = new Banco(077, "Banco Inter S.A.");
        bancos.add(inter);
        itau = new Banco(341, "	Itaú Unibanco S.A.");
        bancos.add(itau);
        c6 = new Banco(336, "Banco C6 S.A – C6 Bank");
        bancos.add(c6);
        nu = new Banco(260, "Nu Pagamentos S.A (Nubank)");
        bancos.add(nu);

        double cpf = 00000000000;
        int opcao;
        int indexBanco = 6;
        char tipoConta = 'P';
        Scanner scan = new Scanner(System.in);

        do {
            do {
                Funcoes.menu();
                opcao = scan.nextInt();
                scan.nextLine();
            } while (opcao < 1 || opcao > 6);

            if (opcao >= 1 && opcao <= 5) {
                indexBanco = Funcoes.selecionaBanco(bancos);
                tipoConta = Funcoes.selecionaTipoConta();
                System.out.println("Informe seu CPF sem separadores ou caracteres especiais:");
                cpf = scan.nextDouble();
            }
            switch (opcao) {
                case 1:
                    bancos.get(indexBanco).criarConta(tipoConta, cpf, todosClientes);
                    break;

                case 2:
                    bancos.get(indexBanco).sacar(tipoConta, cpf);
                    break;

                case 3:
                    bancos.get(indexBanco).depositar(tipoConta, cpf);
                    break;

                case 4:
                    bancos.get(indexBanco).transferir(tipoConta, cpf);
                    break;

                case 5:
                    bancos.get(indexBanco).imprimirExtrato(tipoConta, cpf);
                    break;
            }
        } while (opcao != 6);
        scan.close();
    }
}