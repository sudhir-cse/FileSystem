package com.kpit.sudhir.elements

abstract class FileSystemEntry(val name: String, val parentPath: String) {
  def path: String = parentPath + Directory.DELIMITER + name
  def asDirectory: Directory
  def getType: String
}
