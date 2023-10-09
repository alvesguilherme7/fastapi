/*
 * FastAPI
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.alvesguilherme.fastapi.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
/**
 * Lancamento
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-10-07T08:55:07.825-03:00[America/Sao_Paulo]")

public class Lancamento {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("descricao")
  private String descricao = "";

  @SerializedName("valor")
  private BigDecimal valor = new BigDecimal(0.0);

  @SerializedName("conta_gerencial")
  private String contaGerencial = "";

  @SerializedName("banco")
  private String banco = "";

  @SerializedName("cliente_fornecedor")
  private String clienteFornecedor = "";

  @SerializedName("data_emissao")
  private Date dataEmissao = null;

  @SerializedName("data_vencimento")
  private Date dataVencimento = null;

  @SerializedName("data_fluxo")
  private Date dataFluxo = null;

  @SerializedName("data_conciliado")
  private Date dataConciliado = null;

  @SerializedName("aprovado")
  private Boolean aprovado = false;

  @SerializedName("previsao")
  private Boolean previsao = false;

  @SerializedName("cheque")
  private String cheque = "";

  @SerializedName("documento")
  private String documento = "";

  @SerializedName("observacoes")
  private String observacoes = "";

  @SerializedName("transferencia")
  private String transferencia = "";

  @SerializedName("historico_parciais")
  private String historicoParciais = "";

  public Lancamento id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Lancamento descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

   /**
   * Get descricao
   * @return descricao
  **/
  
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Lancamento valor(BigDecimal valor) {
    this.valor = valor;
    return this;
  }

   /**
   * Get valor
   * @return valor
  **/
  
  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public Lancamento contaGerencial(String contaGerencial) {
    this.contaGerencial = contaGerencial;
    return this;
  }

   /**
   * Get contaGerencial
   * @return contaGerencial
  **/
  
  public String getContaGerencial() {
    return contaGerencial;
  }

  public void setContaGerencial(String contaGerencial) {
    this.contaGerencial = contaGerencial;
  }

  public Lancamento banco(String banco) {
    this.banco = banco;
    return this;
  }

   /**
   * Get banco
   * @return banco
  **/
  
  public String getBanco() {
    return banco;
  }

  public void setBanco(String banco) {
    this.banco = banco;
  }

  public Lancamento clienteFornecedor(String clienteFornecedor) {
    this.clienteFornecedor = clienteFornecedor;
    return this;
  }

   /**
   * Get clienteFornecedor
   * @return clienteFornecedor
  **/
  
  public String getClienteFornecedor() {
    return clienteFornecedor;
  }

  public void setClienteFornecedor(String clienteFornecedor) {
    this.clienteFornecedor = clienteFornecedor;
  }

  public Lancamento dataEmissao(Date dataEmissao) {
    this.dataEmissao = dataEmissao;
    return this;
  }

   /**
   * Get dataEmissao
   * @return dataEmissao
  **/
  
  public Date getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(Date dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public Lancamento dataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
    return this;
  }

   /**
   * Get dataVencimento
   * @return dataVencimento
  **/
  
  public Date getDataVencimento() {
    return dataVencimento;
  }

  public void setDataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public Lancamento dataFluxo(Date dataFluxo) {
    this.dataFluxo = dataFluxo;
    return this;
  }

   /**
   * Get dataFluxo
   * @return dataFluxo
  **/
  
  public Date getDataFluxo() {
    return dataFluxo;
  }

  public void setDataFluxo(Date dataFluxo) {
    this.dataFluxo = dataFluxo;
  }

  public Lancamento dataConciliado(Date dataConciliado) {
    this.dataConciliado = dataConciliado;
    return this;
  }

   /**
   * Get dataConciliado
   * @return dataConciliado
  **/
  
  public Date getDataConciliado() {
    return dataConciliado;
  }

  public void setDataConciliado(Date dataConciliado) {
    this.dataConciliado = dataConciliado;
  }

  public Lancamento aprovado(Boolean aprovado) {
    this.aprovado = aprovado;
    return this;
  }

   /**
   * Get aprovado
   * @return aprovado
  **/
  
  public Boolean isAprovado() {
    return aprovado;
  }

  public void setAprovado(Boolean aprovado) {
    this.aprovado = aprovado;
  }

  public Lancamento previsao(Boolean previsao) {
    this.previsao = previsao;
    return this;
  }

   /**
   * Get previsao
   * @return previsao
  **/
  
  public Boolean isPrevisao() {
    return previsao;
  }

  public void setPrevisao(Boolean previsao) {
    this.previsao = previsao;
  }

  public Lancamento cheque(String cheque) {
    this.cheque = cheque;
    return this;
  }

   /**
   * Get cheque
   * @return cheque
  **/
  
  public String getCheque() {
    return cheque;
  }

  public void setCheque(String cheque) {
    this.cheque = cheque;
  }

  public Lancamento documento(String documento) {
    this.documento = documento;
    return this;
  }

   /**
   * Get documento
   * @return documento
  **/
  
  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public Lancamento observacoes(String observacoes) {
    this.observacoes = observacoes;
    return this;
  }

   /**
   * Get observacoes
   * @return observacoes
  **/
  
  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public Lancamento transferencia(String transferencia) {
    this.transferencia = transferencia;
    return this;
  }

   /**
   * Get transferencia
   * @return transferencia
  **/
  
  public String getTransferencia() {
    return transferencia;
  }

  public void setTransferencia(String transferencia) {
    this.transferencia = transferencia;
  }

  public Lancamento historicoParciais(String historicoParciais) {
    this.historicoParciais = historicoParciais;
    return this;
  }

   /**
   * Get historicoParciais
   * @return historicoParciais
  **/
  
  public String getHistoricoParciais() {
    return historicoParciais;
  }

  public void setHistoricoParciais(String historicoParciais) {
    this.historicoParciais = historicoParciais;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lancamento lancamento = (Lancamento) o;
    return Objects.equals(this.id, lancamento.id) &&
        Objects.equals(this.descricao, lancamento.descricao) &&
        Objects.equals(this.valor, lancamento.valor) &&
        Objects.equals(this.contaGerencial, lancamento.contaGerencial) &&
        Objects.equals(this.banco, lancamento.banco) &&
        Objects.equals(this.clienteFornecedor, lancamento.clienteFornecedor) &&
        Objects.equals(this.dataEmissao, lancamento.dataEmissao) &&
        Objects.equals(this.dataVencimento, lancamento.dataVencimento) &&
        Objects.equals(this.dataFluxo, lancamento.dataFluxo) &&
        Objects.equals(this.dataConciliado, lancamento.dataConciliado) &&
        Objects.equals(this.aprovado, lancamento.aprovado) &&
        Objects.equals(this.previsao, lancamento.previsao) &&
        Objects.equals(this.cheque, lancamento.cheque) &&
        Objects.equals(this.documento, lancamento.documento) &&
        Objects.equals(this.observacoes, lancamento.observacoes) &&
        Objects.equals(this.transferencia, lancamento.transferencia) &&
        Objects.equals(this.historicoParciais, lancamento.historicoParciais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, descricao, valor, contaGerencial, banco, clienteFornecedor, dataEmissao, dataVencimento, dataFluxo, dataConciliado, aprovado, previsao, cheque, documento, observacoes, transferencia, historicoParciais);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lancamento {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    contaGerencial: ").append(toIndentedString(contaGerencial)).append("\n");
    sb.append("    banco: ").append(toIndentedString(banco)).append("\n");
    sb.append("    clienteFornecedor: ").append(toIndentedString(clienteFornecedor)).append("\n");
    sb.append("    dataEmissao: ").append(toIndentedString(dataEmissao)).append("\n");
    sb.append("    dataVencimento: ").append(toIndentedString(dataVencimento)).append("\n");
    sb.append("    dataFluxo: ").append(toIndentedString(dataFluxo)).append("\n");
    sb.append("    dataConciliado: ").append(toIndentedString(dataConciliado)).append("\n");
    sb.append("    aprovado: ").append(toIndentedString(aprovado)).append("\n");
    sb.append("    previsao: ").append(toIndentedString(previsao)).append("\n");
    sb.append("    cheque: ").append(toIndentedString(cheque)).append("\n");
    sb.append("    documento: ").append(toIndentedString(documento)).append("\n");
    sb.append("    observacoes: ").append(toIndentedString(observacoes)).append("\n");
    sb.append("    transferencia: ").append(toIndentedString(transferencia)).append("\n");
    sb.append("    historicoParciais: ").append(toIndentedString(historicoParciais)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
