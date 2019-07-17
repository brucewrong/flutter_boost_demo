import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_boost_module/base_page.dart';

class ThirdPage extends BasePage {

  ThirdPage({
    Key key,
    int enterType,
  }) : super(key : key, enterType : enterType);

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return ThirdPageState();
  }
}


class ThirdPageState extends State<ThirdPage> {
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
        title: Text('Third Flutter Page'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Container(
            height: 200,
            child: Text(
              '第三个 flutter 页面',
              style: TextStyle(fontSize: 20),
            ),
          ),
        ],
      ),
    );
  }
}
