Utilizamos no projeto o H2 como banco e swagger para expor os endpoints

#### Acesso local com o swagger: http://localhost:8081/swagger-ui.html

#### adopter-controller

* GET /api/v1/adopter/{id} -> getById
* GET /api/v1/adopter      -> getAllAdopter
* GET /api/v1/adopter/preferences/{id} -> getByIdAdopterPreferences
* POST /api/v1/adopter/    -> addNewAdopter
* PUT /api/v1/adopter/{id}  -> changeAdopter
* PATCH /api/v1/adopter/{id} -> addAdopterPreferences
* DELETE /api/v1/adopter/{id} -> deleteAdopter

#### chose-controller
* GET /api/v1/chose     -> performPetAdoption
* POST /api/v1/chose/{id} -> getListSelectedPets

#### donor-controller
* GET /api/v1/donor -> getAllDonor
* GET /api/v1/donor/{id} getDonorById
* POST /api/v1/donor -> addNewDonor
* PUT /api/v1/donor/{id} -> changeDonor
* DELETE /api/v1/donor -> deleteDonor

#### pet-controller
* GET /api/v1/pet -> getAllPet
* GET /api/v1/pet/{id} getPetById
* POST /api/v1/pet -> addNewPet
* PUT /api/v1/pet/{id} -> changePet
* DELETE /api/v1/pet -> deletePet
