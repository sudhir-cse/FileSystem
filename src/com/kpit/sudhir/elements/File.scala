package com.kpit.sudhir.elements

class File(override val name: String, override val parentPath: String)
    extends FileSystemEntry(name, parentPath) {

  override def asDirectory: Directory = ???
  override def getType: String = ???
}
