package net.yefremov.sample.codegen

import net.yefremov.sample.codegen.ast.TreehuggerGenerator
import net.yefremov.sample.codegen.schema.TypeSchema
import net.yefremov.sample.codegen.template.TwirlGenerator

object Main extends App {

  val schema = TypeSchema.fromJson("sample/src/main/resources/Foo.json")

  println("showing Twirl generator:")
  println((new TwirlGenerator).generate(schema))
  println("showing Treehugger generator:")
  println((new TreehuggerGenerator).generate(schema))

  println(s"got ${schema.name.shortName} back")
}
