package com.kpit.sudhir.filesystem

import com.kpit.sudhir.elements.Directory

class State(val rootDir: Directory,
            val workingDir: Directory,
            val prevCmdResult: String) {

  def show = print(State.SHELL_TOKEN)
}

object State {
  val SHELL_TOKEN = "$ "

  def apply(rootDir: Directory,
            workingDir: Directory,
            prevCmdResult: String = "") =
    new State(rootDir, workingDir, prevCmdResult)

}
