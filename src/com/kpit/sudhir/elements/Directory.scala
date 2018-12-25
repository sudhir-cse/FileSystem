package com.kpit.sudhir.elements

class Directory(override val dirName: String,
                override val parentPath: String,
                val contents: List[FileSystemEntry])
    extends FileSystemEntry(dirName, parentPath) {

  override def asDirectory: Directory = this

  def findDescendant(path: List[String]): Directory = {
    if (path.isEmpty) this
    else findEntry(path.head).asDirectory.findDescendant(path.tail)
  }

  def hasEntry(name: String): Boolean = findEntry(name) != null

  def findEntry(name: String): Directory = {
    val fsEntries =
      contents.filter(fsEntry => fsEntry.dirName.equals(name))
    if (fsEntries.isEmpty) null
    else fsEntries.head.asDirectory
  }

  def replaceEntry(entryName: String, newEntry: Directory): Directory =
    new Directory(
      dirName,
      parentPath,
      contents.filter(e => !e.dirName.equals(entryName)) :+ newEntry)

  def allDirNamesInPath: List[String] =
    path.substring(1).split(Directory.DELIMITER).toList.filter(e => !e.isEmpty)

  def addEntry(newEntry: FileSystemEntry): Directory =
    new Directory(dirName, parentPath, contents :+ newEntry)
}

object Directory {
  val ROOT_PATH = "/"
  val DELIMITER = "/"

  def ROOT = Directory.createEmptyDir("", "")

  def createEmptyDir(name: String, parentPath: String): Directory =
    new Directory(name, parentPath, List())
}
