# API para gerenciar usuários e departamentos (CRUD).

# Tecnologias
Java
Spring Boot
Spring Data JPA
SpringDoc OpenAPI 3
MySQL

# Práticas adotadas
Consultas com Spring Data JPA
Geração automática de documentação com o Swagger da OpenAPI 3.



# Criar usuário
$ http POST :8080/users

{
        
        "name": "Maria",
        "email": "maria@gmail.com",
        "department": {
            "id": 1,
           
        }
    }

Se colocar id = 1 em department, o departamento será gestão, se colocar id = 2 em department, o departamento será informática.
# Listar usuários

Para listar usuários, é necessário usar o GET.
exemplo:

http GET:8080/users

Dessa forma, todos os usuários na lista, irão aparecer.
[


    {
        "id": 1,
        "name": "Maria",
        "email": "maria@gmail.com",
        "department": {
            "id": 1,
            "nome": "Gestão"
        }
    },
    
    {
        "id": 2,
        "name": "Bob",
        "email": "bob@gmail.com",
        "department": {
            "id": 1,
            "nome": "Gestão"
        }
    },
    {
        "id": 3,
        "name": "Alex",
        "email": "alex@gmail.com",
        "department": {
            "id": 2,
            "nome": "Informática"
        }
    },
    {
        "id": 4,
        "name": "Ana",
        "email": "ana@testes.com",
        "department": {
            "id": 2,
            "nome": "Informática"
        }
    }


]

# Retornar um usuário

Para ver apenas um usuário, é necessário usar o GET e passar o id do usuário.
exemplo:

http GET:8080/users/1

    {
        "id": 1,
        "name": "Maria",
        "email": "maria@gmail.com",
        "department": {
            "id": 1,
            "nome": "Gestão"
            
        }
    }

Dessa forma o usuário com id igual a 1, será retornado.





# Atualizar informações

Para atualizar as informações dos usuários, é necessário usar o PUT e passar as informações do usuário que deseja atualizar.
exemplo:

http PUT :8080/users


   Antes de atualizar:        

    {
        "id": 2,
        "name": "Bob",
        "email": "Bob@gmail.com",
        "department": {
            "id": 1,
            "nome": "Gestão"
            
        }
    }

    
Passando informações

    {
        "id": 2,
        "name": "jonas",
        "email": "jonas@gmail.com",
        "department": {
            "id": 2
            
            
        }
    }


Depois de atualizar:

    {
        "id": 2,
        "name": "jonas",
        "email": "jonas@gmail.com",
        "department": {
            "id": 2
            "nome": "Informática"
            
        }
    }








# Remover usuários
Para remover usuários, é necessário usar o Delete e passar o id do usuário.
exemplo:

http DELETE :8080/users/1

o usuário com id igual a 1 será deletado.



