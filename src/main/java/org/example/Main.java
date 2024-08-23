package org.example;


import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    //Scannerオブジェクトや各所で使う変数を定義
    Scanner scanner = new Scanner(System.in);
    String input;
    int num1;
    String operator = "";
    int num2;
    int result = 0;

    //1番目の数字を入力
    while (true) {
      System.out.print("1番目の数字を入力してください: ");
      input = scanner.next();
      try {
        num1 = Integer.parseInt(input);
        break;
      } catch (NumberFormatException e) {
        System.out.println("無効な文字が入力されています");
      }
    }

    //演算子を入力
    while (!operator.matches("[+\\-*/]")) {
      System.out.print("四則演算子を入力してください (+, -, *, /): ");
      operator = scanner.next();
      if (operator.matches("[+\\-*/]")) {
        break;
      } else {
        System.out.println("無効な文字が入力されています");
      }
    }

    //2番目の数字を入力
    while (true) {
      System.out.print("2番目の数字を入力してください: ");
      input = scanner.next();
      try {
        num2 = Integer.parseInt(input);
        if (num2 == 0 && operator.equals("/")) {
          System.out.println("0で割ることは出来ません");
        } else {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("無効な文字が入力されています");
      }
    }

    //計算処理
    switch (operator) {
      case "+" -> result = num1 + num2;
      case "-" -> result = num1 - num2;
      case "*" -> result = num1 * num2;
      case "/" -> result = num1 / num2;
    }
    System.out.println("計算結果: " + num1 + " " + operator + " " + num2 + " = " + result);
    scanner.close();
  }
}
