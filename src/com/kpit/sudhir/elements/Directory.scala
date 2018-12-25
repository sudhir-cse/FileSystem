package com.kpit.sudhir.elements

class Directory(override val dirName: String,
                override val parentPath: String,
                val contents: List[FileSystemEntry])
    extends FileSystemEntry(dirName, parentPath) {}

object Directory {
  val ROOT_PATH = "/"
  val DELIMITER = "/"

  def ROOT = Directory.createEmptyDir("", "")

  def createEmptyDir(name: String, parentPath: String): Directory =
    new Directory(name, parentPath, List())
}
