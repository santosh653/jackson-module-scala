package com.fasterxml.jackson.module.scala.ser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.{BaseSpec, DefaultScalaModule}
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Scala3Test extends BaseSpec {
  "An ObjectMapper" should "serialize a Scala3 case class" in {
    val mapper = new ObjectMapper
    mapper.registerModule(new DefaultScalaModule)
    val model = com.github.pjfanning.scala3.Scala3CaseClass("name", Some("desc"))
    val json = mapper.writeValueAsString(model)
    json should include(""""name":"name"""")
    json should include(""""desc":"desc"""")
  }
  "An ObjectMapper" should "serialize a Scala3 case object" in {
    val mapper = new ObjectMapper
    mapper.registerModule(new DefaultScalaModule)
    val json = mapper.writeValueAsString(com.github.pjfanning.scala3.Scala3CaseObject)
    json should include(""""field1":"test"""")
    json should include(""""field2":42""")
  }
}
