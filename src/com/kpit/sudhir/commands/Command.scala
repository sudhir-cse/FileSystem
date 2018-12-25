package com.kpit.sudhir.commands
import com.kpit.sudhir.filesystem.State

trait Command {
  def apply(state: State): State
}

object Command {
  def from(cmdString: String): Command = new CmdNotFound
}
