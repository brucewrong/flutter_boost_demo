import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_boost_module/base_page.dart';
import 'package:flutter_boost_module/second_page.dart';

class FirstPage extends BasePage {

  FirstPage({
    Key key,
    int enterType,
  }) : super(key : key, enterType: enterType);

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return FirstPageState();
  }
}

class FirstPageState extends State<FirstPage> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(
        leading: InkWell(
          child: Icon(
            Icons.arrow_back,
            size: 20,
          ),
          onTap: () {
            widget.exitPage(context);
          },
        ),
        title: Text('First Flutter Page'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Container(
            height: 100,
            child: Text(
              '第一个 flutter 页面',
              style: TextStyle(fontSize: 20),
            ),
          ),
          MaterialButton(
            child: Text('跳转第一个 native 页面'),
            color: Colors.blue,
            highlightColor: Colors.blueAccent,
            onPressed: () {
              FlutterBoost.singleton.openPage("flutterbus://nativeFirstPage", {
                "query": {"description": "大家好，我来自First Flutter页面!!!!!!!!"}
              });
            },
          ),
          MaterialButton(
            child: Text('通过内部push方式跳转第二个 flutter 页面'),
            color: Colors.blue,
            highlightColor: Colors.blueAccent,
            onPressed: () {
              Navigator.of(context).push(MaterialPageRoute(builder: (context){
                return SecondPage(enterType: 1,);
              }));
//              FlutterBoost.singleton.openPage("flutterbus://flutterSecondPage", {});
            },
          ),
        ],
      ),
    );
  }
}
