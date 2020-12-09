package com.fasterxml.jackson.module.scala.deser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.{BaseSpec, DefaultScalaModule}
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Scala3Test extends BaseSpec {
  "An ObjectMapper" should "deserialize a Scala3 case class" in {
    val mapper = new ObjectMapper
    mapper.registerModule(new DefaultScalaModule)
    val json = """{"name":"name","desc":"desc"}"""
    val model = mapper.readValue(json, classOf[com.github.pjfanning.scala3.Scala3CaseClass])
    model.name shouldEqual "name"
    model.desc shouldEqual Some("desc")
  }
}
