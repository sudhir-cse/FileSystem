package com.kpit.sudhir.filesystem

import java.util.Scanner

object Main extends App {
  val scanner = new Scanner(System.in)

  while (true) {
    print("$ ")
    val command = scanner.nextLine()
    println(command)
  }
}
