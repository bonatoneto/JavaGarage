package front;

public class Main {
  public static void main(String[] args) {
    int opc;
    do {
      System.out.println("\n");
      System.out.println("**********JAVA GARAGE**********");
      System.out.println("\n");
      System.out.println("---------MENU PRINCIPAL----------");
      System.out.println("1 - Clientes");
      System.out.println("2 - Mecanicos");
      System.out.println("3 - Serviços");
      System.out.println("4 - Sair");
      opc = Console.readInt("Opção: ");
      switch (opc) {
        case 1:
          new AppClientes();
          break;
      }
    } while (opc != 4);
  }
}
