INSERT INTO tb_adotante(id,email,foto,localizacao,nome,telefone,especie,porte,tipo_pet) VALUES (1L,'MARCIA@GMAIL.COM','FOTO1.JPG','3453-35435','BRUNO','51-995535549','MAMIFERO','PEQUENO','GATO');

INSERT INTO tb_doador(id,email,foto,localizacao,nome,telefone) VALUES (2L,'brunovicentealves.ti@gmail.com','FOTO1.JPG','3453-35435','Bruno','51-995535549');

INSERT INTO tb_pet(id,ambiente,cor,especie,foto,idade,nome,porte,tipo_pet,vacinado,id_doador) VALUES (3L,'TERRESTRE','MARRON','MAMIFERO','FOTO2.JPG',2,'NESCAU','PEQUENO','GATO','VACINADO',2);

INSERT INTO tb_adotante_pet(status,pet_id,adopter_id) VALUES (1,3,1);