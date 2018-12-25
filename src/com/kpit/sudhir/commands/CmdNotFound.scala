package com.kpit.sudhir.commands

import com.kpit.sudhir.filesystem.State

class CmdNotFound extends Command {
  override def apply(state: State): State = state.setMessage("Command not recognized")
}
