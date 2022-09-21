import 'package:flutter/material.dart';

import 'login.dart';

class Home extends StatelessWidget {
  Widget build(BuildContext context) {
    return Builder(
      builder: (context) => Scaffold(body: Center(child: LoginScreen())),
    );
  }
}
