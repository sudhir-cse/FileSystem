package com.kpit.sudhir.commands

import com.kpit.sudhir.elements.{Directory, FileSystemEntry}
import com.kpit.sudhir.filesystem.State

class Mkdir(val name: String) extends Command {

  override def apply(state: State): State = {
    val workingDir = state.workingDir
    if (workingDir.hasEntry(name)) {
      state.setMessage($"Name already exists!")
    } else if (name.contains("/")) {
      state.setMessage("Separator is not allowed as part of directory name")
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
    val workingDir = state.workingDir

    val allDirNamesInPath: List[String] = workingDir.allDirNamesInPath

    val newDirectory = Directory.createEmptyDir(name, workingDir.path)

    val newRoot =
      updateStructure(state.rootDir, allDirNamesInPath, newDirectory)

    val newWorkingDir = newRoot.findDescendant(allDirNamesInPath)

    State(newRoot, newWorkingDir)
  }

  def updateStructure(currentDirectory: Directory,
                      path: List[String],
                      newEntry: FileSystemEntry): Directory = {

    if (path.isEmpty) currentDirectory.addEntry(newEntry)
    else {
      val oldEntry = currentDirectory.findEntry(path.head).asDirectory
      currentDirectory.replaceEntry(
        oldEntry.dirName,
        updateStructure(oldEntry, path.tail, newEntry))
    }
  }
}
