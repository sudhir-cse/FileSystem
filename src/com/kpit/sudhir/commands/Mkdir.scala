package com.kpit.sudhir.commands

import com.kpit.sudhir.filesystem.State

class Mkdir(val name: String) extends Command {
  override def apply(state: State): State = {
    val workingDir = state.workingDir
    if (workingDir.hasEntry(name)) {
      state.setMessage($"Name already exists!")
    } else if (name.contains("/")) {
      state.setMessage("Seperator is not allowed as part of directory name")
    } else if (checkIllegal(name)) {
      state.setMessage("Illegal name")
    } else {
      makeDir(state, name)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".") || name.startsWith("~")
  }

  def makeDir(state: State, name: String): State = {
    ???
  }
}
