package com.kpit.sudhir.elements

class Directory(override val dirName: String,
                override val parentPath: String,
                val contents: List[FileSystemEntry])
    extends FileSystemEntry(dirName, parentPath) {

  def hasEntry(name: String): Boolean = ???

  def allDirNamesInPath: List[String] = ???

  def findDescendant(path: List[String]): Directory = ???

}

object Directory {
  val ROOT_PATH = "/"
  val DELIMITER = "/"

  def ROOT = Directory.createEmptyDir("", "")

  def createEmptyDir(name: String, parentPath: String): Directory =
    new Directory(name, parentPath, List())
}
