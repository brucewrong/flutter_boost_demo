import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_boost_module/base_page.dart';

class SecondPage extends BasePage {
  SecondPage({
    Key key,
    int enterType,
  }) : super(key: key, enterType: enterType);

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return SecondPageState();
  }
}

class SecondPageState extends State<SecondPage> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(
        leading: GestureDetector(
          child: Icon(
            Icons.arrow_back,
            size: 15,
          ),
          onTap: () {
            widget.exitPage(context);
          },
        ),
        title: Text('Second Flutter Page'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Container(
            height: 100,
            child: Text(
              '第二个 flutter 页面',
              style: TextStyle(fontSize: 20),
            ),
          ),
          MaterialButton(
            child: Text('跳转第二个 native 页面并返回结果'),
            color: Colors.blue,
            highlightColor: Colors.blueAccent,
            onPressed: () {
              FlutterBoost.singleton.openPage(
                  "flutterbus://nativeSecondPage",
                  {
                    "query": {"requestCode":1000, "type": "second"}
                  },
                  resultHandler: (String key, Map<dynamic, dynamic> result) {
                print("==============> key: $key, result: $result");
              });
            },
          ),
          MaterialButton(
            child: Text('通过FlutterBoost openPage方法跳转第三个 flutter 页面'),
            color: Colors.blue,
            highlightColor: Colors.blueAccent,
            onPressed: () async {
              await FlutterBoost.singleton
                  .openPage("flutterbus://flutterThirdPage", {
                "query": {
                  "id": 321,
                  "name": "xiaoming",
                  "from": "second flutter page"
                }
              });
            },
          ),
        ],
      ),
    );
  }
}
