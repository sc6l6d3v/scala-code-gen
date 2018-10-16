package net.yefremov.sample.codegen.schema

/**
 * Represents a fully qualified type name.
 * @author Dmitriy Yefremov
 */
case class TypeName(fullName: String) {

  private def lastDot: List[String] = fullName.split("\\.").toList

  def packageName: String = lastDot.init.mkString(".")

  def shortName: String = lastDot.last

}
