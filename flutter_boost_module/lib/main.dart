import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_boost_module/first_page.dart';
import 'package:flutter_boost_module/second_page.dart';
import 'package:flutter_boost_module/third_page.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {

  @override
  MyAppState createState() => MyAppState();
}

class MyAppState extends State<MyApp> {


  @override
  void initState() {
    super.initState();

    FlutterBoost.singleton.registerPageBuilders({
      'flutterbus://flutterFirstPage': (pageName, params, _) {
        print("first flutterPage params:$params");
        print("first ================> id = ${params["id"]}");
        print("first ================> name = ${params["name"]}");
        return FirstPage();
      },
      'flutterbus://flutterSecondPage': (pageName, params, _) {
        print("second flutterPage params:$params");
        print("second ================> id = ${params["id"]}");
        print("second ================> name = ${params["name"]}");
        print("second ================> address = ${params["address"]}");
        return SecondPage();
      },
      'flutterbus://flutterThirdPage': (pageName, params, _) {
        print("third flutterPage params:$params");

        return ThirdPage();
      }
    });
    FlutterBoost.handleOnStartPage();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Boost example',
        builder: FlutterBoost.init(),
        home: Container());
  }
}
