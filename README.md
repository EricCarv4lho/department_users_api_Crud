# List


API para gerenciar usuários e departamentos (CRUD).

# Tecnologias
java | 
Spring Boot |
Spring Data JPA |
H2 Database




API Endpoints
Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta httpie:

Criar usuário
$ http POST :8080/todos nome="Todo 1" descricao="Desc Todo 1" prioridade=1

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
# Atualizar informações

Para atualizar as informações dos usuários, é necessário usar o PUT e passar as informações do usuário que deseja atualizar.
exemplo:

http PUT :8080/users


   Antes de atualizar:                                      Passando informações

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

http DELETE :8080/todos/1

o usuário com id igual a 1 será deletado.

