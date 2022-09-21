import 'package:flutter/material.dart';

class SignUp extends StatefulWidget {
  _SignUp createState() => _SignUp();
}

class _SignUp extends State<SignUp> {
  final _formkey = GlobalKey<FormState>();

  Widget build(BuildContext context) {
    return Material(
        child: Builder(
            builder: (context) => Scaffold(
                body: SafeArea(
                    child: Form(
                        key: _formkey,
                        child: Center(
                            child: Column(children: [
                          TextFormField(
                              decoration:
                                  InputDecoration(hintText: 'Diigite seu Nome'),
                              validator: (value) {
                                if (value == null || value.isEmpty) {
                                  return 'Você precisa digitar algum nome';
                                }
                                // onChanged:(novoNome){
                                //   Provider<Cadastro>(context).
                                // }
                                return null;
                              }),
                          TextFormField(
                              decoration: InputDecoration(
                                  hintText: 'Digite seu e-mail'),
                              validator: (value) {
                                if (value == null ||
                                    value.isEmpty ||
                                    !value.contains("@")) {
                                  return 'Você precisa digitar um e-mail valido';
                                }
                              }),
                          TextFormField(
                            decoration: InputDecoration(
                                hintText: 'Digite seu Telefone Principal'),
                            keyboardType: TextInputType.number,
                          ),
                          TextFormField(
                            decoration:
                                InputDecoration(hintText: 'Digite seu CEP'),
                            keyboardType: TextInputType.number,
                          ),
                          TextFormField(
                              decoration: InputDecoration(
                                  hintText: 'Passe a url de sua Foto'),
                              validator: (value) {
                                if (value == null || value.isEmpty) {
                                  return 'Digite uma url valida';
                                }
                              }),
                          ElevatedButton(
                              onPressed: () {
                                if (_formkey.currentState!.validate()) {
                                  ScaffoldMessenger.of(context).showSnackBar(
                                      const SnackBar(
                                          content: Text('Processing Data')));
                                }
                              },
                              child: Text("Enviar"))

                          // Consumer<Cadastro>(
                          //   builder:(context, cadastro, child) => Text(
                          //     ' Meu Nome é ${cadastro.nome}'
                          //   )
                          // ),
                        ])))))));
  }
}
