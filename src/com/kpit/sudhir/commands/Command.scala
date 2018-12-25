package com.kpit.sudhir.commands
import com.kpit.sudhir.filesystem.State

trait Command {
  def apply(state: State): State
}
