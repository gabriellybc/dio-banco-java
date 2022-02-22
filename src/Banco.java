import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

  private int codigo;
  private String nome;
  private List<Cliente> clientes;

  public Banco(int codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
    this.clientes = new ArrayList<Cliente>();
  }

  public void criarConta(char tipoConta, double cpf, List<Cliente> todosClientes) {
    for (Cliente cliente : todosClientes) {
      if (cliente.getCpf() == cpf) {
        if (tipoConta == 'P') {
          ContaPoupanca conta = new ContaPoupanca(this);
          cliente.getContasPoupancas().add(conta);
        } else {
          ContaCorrente conta = new ContaCorrente(this);
          cliente.getContasCorrentes().add(conta);
        }
        this.clientes.add(cliente);
        return;
      }
    }
    Scanner scan = new Scanner(System.in);
    System.out.println("Informe seu nome completo:");
    String nomeCompleto = scan.nextLine().toUpperCase();
    Cliente cliente = new Cliente(cpf, nomeCompleto);
    if (tipoConta == 'P') {
      ContaPoupanca conta = new ContaPoupanca(this);
      cliente.getContasPoupancas().add(conta);
    } else {
      ContaCorrente conta = new ContaCorrente(this);
      cliente.getContasCorrentes().add(conta);
    }
    this.clientes.add(cliente);
    todosClientes.add(cliente);
  }

  public void sacar(char tipoConta, double cpf) {
    for (Cliente cliente : this.clientes) {
      if (cpf == cliente.getCpf()) {
        if (tipoConta == 'P') {
          for (Conta conta : cliente.getContasPoupancas()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.sacar();
              return;
            }
          }
        } else {
          for (Conta conta : cliente.getContasCorrentes()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.sacar();
              return;
            }
          }
        }
      }
    }
    System.out.println("Conta não encontrada! Crie a conta desejada no banco " + this.nome);
  }

  public void depositar(char tipoConta, double cpf) {
    for (Cliente cliente : this.clientes) {
      if (cpf == cliente.getCpf()) {
        if (tipoConta == 'P') {
          for (Conta conta : cliente.getContasPoupancas()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.depositar();
              return;
            }
          }
        } else {
          for (Conta conta : cliente.getContasCorrentes()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.depositar();
              return;
            }
          }
        }
      }
    }
    System.out.println("Conta não encontrada! Crie a conta desejada no banco " + this.nome);
  }

  public void transferir(char tipoConta, double cpf) {
    Scanner scan = new Scanner(System.in);
    boolean flag = false;
    for (Cliente cliente : this.clientes) {
      if (cpf == cliente.getCpf()) {
        if (tipoConta == 'P') {
          for (Conta conta : cliente.getContasPoupancas()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.sacar();
              flag = true;
              break;
            }
          }
        } else {
          for (Conta conta : cliente.getContasCorrentes()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.sacar();
              flag = true;
              break;
            }
          }
        }
      }
    }
    if (!flag) {
      System.out.println("Conta não encontrada! Crie a conta desejada no banco " + this.nome);
      return;
    }

    System.out.println("Informes os dados para a conta que você deseja transferir: ");
    tipoConta = Funcoes.selecionaTipoConta();
    System.out.println("Informe o CPF sem separadores ou caracteres especiais para quem você deseja transferir:");
    cpf = scan.nextDouble();
    System.out.println(
        "Informe o mesmo valor de depósito que você informou para o saque!\nPara que a transferência ocorra de maneira correta!");
    for (Cliente cliente : this.clientes) {
      if (cpf == cliente.getCpf()) {
        if (tipoConta == 'P') {
          for (Conta conta : cliente.getContasPoupancas()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.depositar();
              return;
            }
          }
        } else {
          for (Conta conta : cliente.getContasCorrentes()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.depositar();
              return;
            }
          }
        }
      }
    }
    System.out.println("A pessoa para quem você quer despositar ainda não é cliente do banco " + this.nome);
  }

  public void imprimirExtrato(char tipoConta, double cpf) {
    for (Cliente cliente : this.clientes) {
      if (cpf == cliente.getCpf()) {
        if (tipoConta == 'P') {
          for (Conta conta : cliente.getContasPoupancas()) {
            if (conta.banco.getcodigo() == this.codigo) {
              System.out.printf("Titular: %s\n", cliente.getNome());
              conta.imprimirExtrato();
              return;
            }
          }
        } else {
          for (Conta conta : cliente.getContasCorrentes()) {
            if (conta.banco.getcodigo() == this.codigo) {
              conta.imprimirExtrato();
              return;
            }
          }
        }
      }
    }
    System.out.println("Conta não encontrada! Crie a conta desejada no banco " + this.nome);
  }

  public String getNome() {
    return nome;
  }

  public List<Cliente> getClientes() {
    return clientes;
  }

  public void setClientes(List<Cliente> clientes) {
    this.clientes = clientes;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getcodigo() {
    return codigo;
  }

  @Override
  public String toString() {
    return "Banco " + nome + ", codigo " + codigo;
  }

}