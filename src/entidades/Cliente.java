package entidades;

import java.util.List;
public class Cliente {
  private int id;
  private String cpf;
  private String nome;
  private Veiculo veiculo;
  //private List<Servico> servicos;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }
}

//  public void setVeiculo(Veiculo veiculo) {
//    this.veiculo = veiculo;
//  }
//
//  public List<Servico> getServicos() {
//    return servicos;
//  }
//
//  public void setServicos(List<Servico> servicos) {
//    this.servicos = servicos;
//  }
//}
