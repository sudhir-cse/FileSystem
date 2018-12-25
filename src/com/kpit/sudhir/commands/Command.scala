package com.kpit.sudhir.commands
import com.kpit.sudhir.filesystem.State

trait Command {
  def apply(state: State): State
}

object Command {
  val MKDIR = "mkdir"
  val LS = "ls"
  val PWD = "pwd"

  def from(cmdString: String): Command = {
    val tokens = cmdString.split(" ")
    if (cmdString.isEmpty || tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length != 2) incorrectArguments(MKDIR)
      else new Mkdir(tokens(1))
    } else if (LS.equals(tokens(0))) {
      new Ls
    } else if (PWD.equals(tokens(0))) {
      new Pwd
    } else new CmdNotFound
  }

  def emptyCommand = new Command {
    override def apply(state: State): State = state
  }

  def incorrectArguments(command: String): Command = new Command {
    override def apply(state: State): State =
      state.setMessage(
        s"$command: has invalid number of arguments. It accepts exactly one argument.")
  }
}
