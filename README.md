# Projeto API Rest - Gigalink


## Requisitos:

- maven 3.6.3
- Java 11
- PostgreSQL 13

### Criar Transportadora:

```
curl --location --request POST 'localhost:8080/transportadora' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome": "Friburgo Cargas"
}'
```
A resposta esperada é similar e esse Json:
```
{
    "id": 2,
    "nome": "Friburgo Cargas"
}
```
### Criar Pedido:

```
curl --location --request POST 'localhost:8080/pedido' \
--header 'Content-Type: application/json' \
--data-raw '{
    "notaFiscal": "345673-2",
    "valorFrete": 1,
    "desconto": 3,
    "valorTotal": 23458,
    "itens": [{"quantidade": "10", "valor": 234.58, "produto":{"id": 1}}],
    "transportadora": {"id":1}
}'
```
A resposta esperada é similar e esse Json:
```
{
    "id": 4,
    "dataHora": "2022-04-27T19:49:37.166+00:00",
    "notaFiscal": "345673-2",
    "valorFrete": 1,
    "desconto": 3,
    "valorTotal": 23458,
    "transportadora": {"id": 1, "nome": null },
    "itens": [{"id": 4, "quantidade": 10.0, "valor": 234.58, "produto": {"id": 1}}]
}
```

### Criar Fornecedor:

```
curl --location --request POST 'localhost:8080/fornecedor' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome": "Energisa S.A",
    "descricao": "Companhia Elétrica em Nova Friburgo",
    "cidade": "Nova Friburgo",
    "endereco": "Ave. Euterpe Friburguense",
    "bairro": "Centro",
    "numero": 111,
    "emails": [
        {
            "email": "energisa@uol.com",
            "referencia": "trabalho"
        }
    ],
    "telefones": [
        {
            "ddd": "22",
            "numero": "2522-5555",
            "referencia": "escritório"
        }
    ]
}'
```
A resposta esperada é similar e esse Json:
```
{
    "id": 2,
    "nome": "Energisa S.A",
    "descricao": "Companhia Elétrica em Nova Friburgo",
    "cidade": "Nova Friburgo",
    "endereco": "Ave. Euterpe Friburguense",
    "bairro": "Centro",
    "numero": 111,
    "emails": [
        {
            "id": 2,
            "email": "energisa@uol.com",
            "referencia": "trabalho"
        }
    ],
    "telefones": [
        {
            "id": 2,
            "ddd": "22",
            "numero": "2522-5555",
            "referencia": "escritório"
        }
    ]
}
```
### Criar Produto:

```
curl --location --request POST 'localhost:8080/produto' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome": "Conjunto de Renda Emanuelle",
    "descricao": "Conjunto de renda bordada com bojo",
    "fornecedor": {"id": 1}
}'
```
A resposta esperada é similar e esse Json:
```
{
    "id": 8,
    "nome": "Conjunto de Renda Emanuelle",
    "descricao": "Conjunto de renda bordada com bojo",
    "fornecedor": {"id": 1}
}
```

