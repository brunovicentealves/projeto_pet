import 'package:adote1pet/home.dart';
import 'package:adote1pet/login.dart';
import 'package:flutter/material.dart';
import 'cadastro.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  Widget build(BuildContext context) {
    return MaterialApp(routes: {
      '/login': (context) => LoginScreen(),
      '/cadastro': (context) => SignUp()
    }, debugShowCheckedModeBanner: false, home: Home());
  }
}
