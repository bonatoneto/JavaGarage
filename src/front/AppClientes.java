package front;

import entidades.Cliente;
import persistencia.ClientePersistencia;
import negocio.Negocio;

public class AppClientes {
  public AppClientes() {
    int opc;
    do {
      System.out.println("\n");
      System.out.println("*******CLIENTES*******");
      System.out.println("1 - Cadastrar cliente");
      System.out.println("2 - Consultar cliente");
      System.out.println("3 - Excluir cliente");
      opc = Console.readInt("Opcção: ");
      switch (opc) {
        case 1 -> salvarCliente();
        case 2 -> consultarCliente();
        case 3 -> excluirCliente();
      }
    } while (opc != 4);
  }

  private static void salvarCliente() {
    System.out.println("********CADASTRO DE CLIENTES********");
    Cliente objCliente = new Cliente();
    objCliente.setCpf(Console.readString("\n\nInforme o CPF do cliente: "));
    if (Negocio.isCPF(objCliente.getCpf())) {
      if (ClientePersistencia.procurarPorCPF(objCliente) == null) {
        objCliente.setNome(Console.readString("Informe o nome do cliente: "));
        ClientePersistencia.incluir(objCliente);
        System.out.println("\n\nInclusão bem sucedida...");
      } else {
        System.out.println("\n\nCliente já cadastrado...");
      }
    } else {
      System.out.println("\n\nCPF inválido...");
    }
  }

  private static void consultarCliente() {
    System.out.println("\n\n** CONSULTA DE CLIENTES **");
    Cliente objCliente = new Cliente();
    objCliente.setCpf(Console.readString("Informe o CPF a ser consultado: "));
    objCliente = ClientePersistencia.procurarPorCPF(objCliente);
    if (objCliente != null) {
      System.out.println("\n\n-----------------------");
      System.out.println("ID: " + objCliente.getId());
      System.out.println("Nome: " + objCliente.getNome());
      System.out.println("CPF: " + objCliente.getCpf());
    } else {
      System.out.println("\n\nCliente não encontrado...");
    }
  }

  private static void excluirCliente() {
    System.out.println("\n\n** EXCLUIR CLIENTES **");
    Cliente objCliente = new Cliente();
    objCliente.setCpf(Console.readString("Informe o CPF a ser consultado: "));
    objCliente = ClientePersistencia.procurarPorCPF(objCliente);
    if (objCliente != null) {
      System.out.println("\n\n-----------------------");
      System.out.println("ID: " + objCliente.getId());
      System.out.println("Nome: " + objCliente.getNome());
      System.out.println("CPF: " + objCliente.getCpf());
      System.out.println("-----------------------");
      String resp = Console.readString("\n\nQuer excluir esse cliente? ");
      if (resp.equals("S")) {
        if (ClientePersistencia.excluir(objCliente)) {
          System.out.println("\n\nA exclusão foi realizada...");
        } else {
          System.out.println("\n\nA exclusão não pôde ser realizada no momento...");
        }
      }
    } else {
      System.out.println("\n\nCliente não encontrado...");
    }
  }
}