package com.kpit.sudhir.elements

class Directory(override val dirName: String,
                override val parentPath: String,
                val contents: List[FileSystemEntry])
    extends FileSystemEntry(dirName, parentPath) {

  override def asDirectory: Directory = this

  def replaceEntry(entryName: String, newEntry: Directory): Directory = ???

  def hasEntry(name: String): Boolean = ???

  def allDirNamesInPath: List[String] =
    path.substring(1).split(Directory.DELIMITER).toList

  def findDescendant(path: List[String]): Directory = ???

  def addEntry(newEntry: FileSystemEntry): Directory = ???

  def findEntry(name: String): Directory = ???
}

object Directory {
  val ROOT_PATH = "/"
  val DELIMITER = "/"

  def ROOT = Directory.createEmptyDir("", "")

  def createEmptyDir(name: String, parentPath: String): Directory =
    new Directory(name, parentPath, List())
}
