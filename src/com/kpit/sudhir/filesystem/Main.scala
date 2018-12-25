package com.kpit.sudhir.filesystem

import java.util.Scanner

import com.kpit.sudhir.commands.Command
import com.kpit.sudhir.elements.Directory

object Main extends App {
  val scanner = new Scanner(System.in)
  val root = Directory.ROOT
  var state = State(root, root)

  while (true) {
    state.show
    val inputCommand = scanner.nextLine()
    state = Command.from(inputCommand).apply(state)
  }
}
