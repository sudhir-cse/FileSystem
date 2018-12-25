package com.kpit.sudhir.elements

abstract class FileSystemEntry(val dirName: String, val parentPath: String) {
  def path: String = parentPath + Directory.DELIMITER + dirName
  def asDirectory: Directory
}
