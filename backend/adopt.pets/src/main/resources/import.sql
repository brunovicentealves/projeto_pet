INSERT INTO tb_adotante(email,foto,localizacao,nome,telefone,especie,porte,tipo_pet) VALUES ('BRU@GMAIL.COM','FOTO1.JPG','3453-35435','BRUNO','51-995535549','MAMIFERO','PEQUENO','GATO');

INSERT INTO tb_doador(email,foto,localizacao,nome,telefone) VALUES ('MARICA@GMAIL.COM','FOTO1.JPG','3453-35435','MARCIA','51-995535549');

INSERT INTO tb_pet(ambiente,cor,especie,foto,idade,nome,porte,tipoPet,vacinado,id_doador) VALUES ('TERRESTRE','MARRON','MAMIFERO','FOTO2.JPG',2,'NESCAU','PEQUENO','GATO','VACINADO',2);

INSERT INTO tb_adotante_pet(status,pet_id,adopter_id) VALUES (1,3,1);