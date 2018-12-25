package com.kpit.sudhir.commands
import com.kpit.sudhir.filesystem.State

trait Command {
  def apply(state: State): State
}

object Command {
  val MKDIR = "mkdir"
  val LS = "ls"

  def from(cmdString: String): Command = {
    val tokens = cmdString.split(" ")
    if (cmdString.isEmpty || tokens.isEmpty) emptyCommand
    else if (tokens(0).equals(MKDIR)) {
      if (tokens.length != 2) incorrectArguments(MKDIR)
      else new Mkdir(tokens(1))
    } else if (LS.equals(tokens(0))) {
      new Ls
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
