package persistencia;

import entidades.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClientePersistencia {
  public static boolean incluir(Cliente cliente) {
    try {
      EntityManager manager = EntityManagerFactory.getInstance();
      manager.getTransaction().begin();
      manager.persist(cliente);
      manager.getTransaction().commit();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean excluir(Cliente cliente) {
    try {
      EntityManager manager = EntityManagerFactory.getInstance();
      manager.getTransaction().begin();
      manager.remove(cliente);
      manager.getTransaction().commit();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public static Cliente procurarPorCPF(Cliente cliente) {
    EntityManager manager = EntityManagerFactory.getInstance();
    Query consulta = manager.createQuery("FROM cliente WHERE cpf = :param");
    consulta.setParameter("param", cliente.getCpf());
    List<Cliente> clientes = consulta.getResultList();
    if (!clientes.isEmpty()) {
      return clientes.get(0);
    }
    return null;
  }
}