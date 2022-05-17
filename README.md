Criar a tabela pessoa_table.json que se encontra na pasta resources no dynamoDB utilizando 
o comando abaixo:

**aws dynamodb create-table --cli-input-json file://pessoa_table.json --endpoint-url=http://localhost:4566**

Para listar as tabelas, use o comando: 
**aws dynamodb list-tables --endpoint-url=http://localhost:4566**

Para Deletar tabela, use o comando: **aws dynamodb delete-table --endpoint-url=http://localhost:4566 --table-name Pessoa**

--------------------------------------------------------------

Docker

    - Build do jar: gradle bootJar
    - Build da imagem: docker build . -t crud-spring-cloudformation
    - Logar no DockerHub: docker login -u <user>
    - Taguear imagem: docker tag crud-spring-cloudformation <user_dockerhub>/<repo>
    - Fazer push dockerHub: docker push snowgaratti/crud-spring-cloudformation   