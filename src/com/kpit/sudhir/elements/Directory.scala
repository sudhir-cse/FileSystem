package com.kpit.sudhir.elements

class Directory(override val name: String,
                override val parentPath: String,
                val contents: List[FileSystemEntry])
    extends FileSystemEntry(name, parentPath) {

  override def asDirectory: Directory = this

  override def getType: String = "Directory"

  def findDescendant(path: List[String]): Directory = {
    if (path.isEmpty) this
    else findEntry(path.head).asDirectory.findDescendant(path.tail)
  }

  def hasEntry(name: String): Boolean = findEntry(name) != null

  def findEntry(name: String): Directory = {
    val fsEntries =
      contents.filter(fsEntry => fsEntry.name.equals(name))
    if (fsEntries.isEmpty) null
    else fsEntries.head.asDirectory
  }

  def replaceEntry(entryName: String, newEntry: Directory): Directory =
    new Directory(name,
                  parentPath,
                  contents.filter(e => !e.name.equals(entryName)) :+ newEntry)

  def allDirNamesInPath: List[String] =
    path.substring(1).split(Directory.DELIMITER).toList.filter(e => !e.isEmpty)

  def addEntry(newEntry: FileSystemEntry): Directory =
    new Directory(name, parentPath, contents :+ newEntry)
}

object Directory {
  val ROOT_PATH = "/"
  val DELIMITER = "/"

  def ROOT = Directory.createEmptyDir("", "")

  def createEmptyDir(name: String, parentPath: String): Directory =
    new Directory(name, parentPath, List())
}
