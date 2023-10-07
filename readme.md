### Client API FastAPI
<b>v1.0</b>  
O objetivo é fornecer interface para comunicação em java com a API Fast.

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
