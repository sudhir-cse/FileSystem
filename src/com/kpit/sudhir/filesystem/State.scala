package com.kpit.sudhir.filesystem

import com.kpit.sudhir.elements.Directory

class State(val rootDir: Directory,
            val workingDir: Directory,
            val prevCmdResult: String) {

  def show = {
    println(prevCmdResult)
    print(State.SHELL_TOKEN)
  }

  def setMessage(message: String): State = State(rootDir, workingDir, message)
}

object State {
  val SHELL_TOKEN = "$ "

  def apply(rootDir: Directory,
            workingDir: Directory,
            prevCmdResult: String = "") =
    new State(rootDir, workingDir, prevCmdResult)
}
