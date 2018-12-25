package com.kpit.sudhir.commands
import com.kpit.sudhir.filesystem.State

class Pwd extends Command {
  override def apply(state: State): State = {
    state.setMessage(state.workingDir.path)
  }
}
