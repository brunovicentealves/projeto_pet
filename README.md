Projeto adoção de pet


Utilizamos no projeto o H2 como banco e swagger para expor os endpoints

#### Acesso local com o swagger: http://localhost:8081/swagger-ui.html

#### adopter-controller

* GET /api/v1/adopter/{id} -> Retorna um adotante pelo id
* GET /api/v1/adopter      -> Retorna uma lista de adotantes
* GET /api/v1/adopter/preferences/{id}  -> Busca as preferencias de um adotante especifico
* POST /api/v1/adopter/    -> Adciona um adotante nobo
* PUT /api/v1/adopter/{id}  -> Realiza as alteração da informações de um adotante
* PATCH /api/v1/adopter/{id} -> Adciona as preferencias de um adotante especifico
* DELETE /api/v1/adopter/{id} -> Realiza Delete de um adotante

#### chose-controller
* GET /api/v1/chose     -> Buscando lista de pets pela preferencias do adotante

#### email-controller
* POST /api/v1/email-send/{id} -> sendEmail

#### donor-controller
* GET /api/v1/donor -> Buscando uma lista de Doadores
* GET /api/v1/donor/{id} -> Buscando um Doador pelo id
* POST /api/v1/donor -> Adcionando um novo doador
* PUT /api/v1/donor/{id} -> Alterando as informações de um doador
* DELETE /api/v1/donor -> Deletando um doador

#### pet-controller
* GET /api/v1/pet -> Buscando uma lista de pets
* GET /api/v1/pet/{id} -> Buscando um pet por id
* POST /api/v1/pet -> Adcionando um pet novo
* PUT /api/v1/pet/{id} -> Alterando informações de um pet espeficico
* DELETE /api/v1/pet -> Deletando um pet

###match-controller
* GET /api/v1/pet/match -> Buscando lista de Adotantes que manifestaram interesse no pet do doador
* POST /api/v1/pet/match -> Realizando match de adoção entre doador e adotante
* POST /api/v1/pet/match/intention -> Manifestando a intenção de adoção do pet


