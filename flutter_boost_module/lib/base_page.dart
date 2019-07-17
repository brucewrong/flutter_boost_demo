import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';

abstract class BasePage extends StatefulWidget {
  // 0位通过FlutterBoost openPage方法跳转进行，1位通过Flutter中push方式跳转进入
  final int enterType;

  BasePage({Key key, this.enterType = 0}) : super(key: key);

  void exitPage(BuildContext context) {
    if (enterType == 0) {
      FlutterBoost.singleton.closePageForContext(context);
    } else {
      Navigator.pop(context);
    }
  }
}
