### Client API FastAPI
<b>v1.0</b>  
O objetivo � fornecer interface para comunica��o em java com a API Fast.

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
