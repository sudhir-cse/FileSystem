package com.kpit.sudhir.commands
import com.kpit.sudhir.elements.FileSystemEntry
import com.kpit.sudhir.filesystem.State

class Ls extends Command {

  override def apply(state: State): State = {
    val contents = state.workingDir.contents
    val beautifiedOutput = beautifyOutput(contents)
    state.setMessage(beautifiedOutput)
  }

  def beautifyOutput(contents: List[FileSystemEntry]): String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      s"${entry.dirName} [${entry.getType}]\n${beautifyOutput(contents.tail)}"
    }
  }
}
