### Client API FastAPI
<b>v1.0</b>  
O objetivo é fornecer interface para comunicação em java com a API Fast.
[Documentação da API destino v0.1.0](https://api.fluxodecaixa.com.br/docs)

<b>Instanciando o cliente de API</b>

```java
FastAPIClient api = new FastAPIClient.Builder()
    .setUrl("https://api.exemplo.com.br")
    .setCredenciais("usuario", "senha")
    .build();
```

Por padrão o <i>token</i> da API é obtido a cada construção do objeto FastAPIClient ou quando a API
retornar HTTP 401 para a <i>request</i> de negócio. É possível configurar armazenamento durável para 
o token da seguinte forma:
```java
FastAPIClient api = new FastAPIClient.Builder()
    .setUrl("https://api.exemplo.com.br")
    .setCredenciais("usuario", "senha")
    .setFunctionSalvarTokenArmazenado(token -> {
        // salvar o token da forma que for conveniente e durável
    })
    .setFunctionGetTokenArmazenado(() -> {
        // retornar o token do armazenamento durável
        return "token salvo";
    })
    .build();
```

<b> Operações suportadas </b>  
  
Criação de Cliente/Fornecedor
```java
ClienteFornecedor clienteFornecedor = new ClienteFornecedor();
// id não deve ser passado para cadastrar
clienteFornecedor.setRazaoSocial("PNEUS MANIA");
clienteFornecedor.setNome("PNEUS MANIA");
clienteFornecedor.setCpfcnpj("77240706000155");
clienteFornecedor.setTelefone("31996558547");
clienteFornecedor.setEmail("contato@gmail.com");
clienteFornecedor.setObservacao("Não se aplica.");
clienteFornecedor.setGrupoeconomico("9");
clienteFornecedor.setEmpresa("15");
clienteFornecedor.setFixo(false);

api.cadastrarClienteForncedor(clienteFornecedor);

// após a chamada da API o atributo ID será preenchido
System.out.println("Cadastrado com o código:" + clienteFornecedor.getId());
```

Atualização de Cliente/Fornecedor
```java
ClienteFornecedor clienteFornecedor = new ClienteFornecedor();
clienteFornecedor.setId(41197);
clienteFornecedor.setRazaoSocial("PNEUS MANIA");
clienteFornecedor.setNome("PNEUS MANIA");
clienteFornecedor.setCpfcnpj("77240706000155");
clienteFornecedor.setTelefone("31996558547");
clienteFornecedor.setEmail("contato@gmail.com");
clienteFornecedor.setObservacao("Não se aplica.");
clienteFornecedor.setGrupoeconomico("9");
clienteFornecedor.setEmpresa("15");
clienteFornecedor.setFixo(false);

api.atualizarClienteForncedor(clienteFornecedor);
```