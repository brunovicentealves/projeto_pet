import 'package:flutter/material.dart';

class Cadastro with ChangeNotifier {
  String nome = "";
  String email = "";
  String telefone = "11999000999";
  String cep = "06250-000";
  String url = "";

  void saveNome(novoNome) {
    nome = novoNome;
    notifyListeners();
  }

  void saveEmail(novoEmail) {
    email = novoEmail;
    notifyListeners();
  }

  void saveTelefone(novoTelefone) {
    telefone = novoTelefone;
    notifyListeners();
  }

  void saveCep(novoCep) {
    cep = novoCep;
    notifyListeners();
  }

  void saveUrl(novaUrl) {
    url = novaUrl;
    notifyListeners();
  }
}
