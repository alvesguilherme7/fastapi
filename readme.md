### Client API FastAPI
<b>v1.0</b>  
O objetivo � fornecer interface para comunica��o em java com a API Fast.
[Documenta��o da API destino v0.1.0](https://api.fluxodecaixa.com.br/docs)

<b>Instanciando o cliente de API</b>

```java
FastAPIClient api = new FastAPIClient.Builder()
    .setUrl("https://api.exemplo.com.br")
    .setCredenciais("usuario", "senha")
    .build();
```

Por padr�o o <i>token</i> da API � obtido a cada constru��o do objeto FastAPIClient ou quando a API
retornar HTTP 401 para a <i>request</i> de neg�cio. � poss�vel configurar armazenamento dur�vel para 
o token da seguinte forma:
```java
FastAPIClient api = new FastAPIClient.Builder()
    .setUrl("https://api.exemplo.com.br")
    .setCredenciais("usuario", "senha")
    .setFunctionSalvarTokenArmazenado(token -> {
        // salvar o token da forma que for conveniente e dur�vel
    })
    .setFunctionGetTokenArmazenado(() -> {
        // retornar o token do armazenamento dur�vel
        return "token salvo";
    })
    .build();
```

<b> Opera��es suportadas </b>  
  
Cria��o de Cliente/Fornecedor
```java
ClienteFornecedor clienteFornecedor = new ClienteFornecedor();
// id n�o deve ser passado para cadastrar
clienteFornecedor.setRazaoSocial("PNEUS MANIA");
clienteFornecedor.setNome("PNEUS MANIA");
clienteFornecedor.setCpfcnpj("77240706000155");
clienteFornecedor.setTelefone("31996558547");
clienteFornecedor.setEmail("contato@gmail.com");
clienteFornecedor.setObservacao("N�o se aplica.");
clienteFornecedor.setGrupoeconomico("9");
clienteFornecedor.setEmpresa("15");
clienteFornecedor.setFixo(false);

api.cadastrarClienteForncedor(clienteFornecedor);

// ap�s a chamada da API o atributo ID ser� preenchido
System.out.println("Cadastrado com o c�digo:" + clienteFornecedor.getId());
```

Atualiza��o de Cliente/Fornecedor
```java
ClienteFornecedor clienteFornecedor = new ClienteFornecedor();
clienteFornecedor.setId(41197);
clienteFornecedor.setRazaoSocial("PNEUS MANIA");
clienteFornecedor.setNome("PNEUS MANIA");
clienteFornecedor.setCpfcnpj("77240706000155");
clienteFornecedor.setTelefone("31996558547");
clienteFornecedor.setEmail("contato@gmail.com");
clienteFornecedor.setObservacao("N�o se aplica.");
clienteFornecedor.setGrupoeconomico("9");
clienteFornecedor.setEmpresa("15");
clienteFornecedor.setFixo(false);

api.atualizarClienteForncedor(clienteFornecedor);
```