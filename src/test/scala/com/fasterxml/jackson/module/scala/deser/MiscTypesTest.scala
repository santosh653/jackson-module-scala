package com.fasterxml.jackson.module.scala.deser

import java.util.UUID

import com.fasterxml.jackson.module.scala.DefaultScalaModule


class MiscTypesTest extends DeserializerTest {

  def module: DefaultScalaModule.type = DefaultScalaModule

  "Scala Module" should "deserialize UUID" in {
    val data: Seq[UUID] = Stream.continually(UUID.randomUUID).take(4).toList

    val json = newMapper.writeValueAsString(data)
    val read = deserialize[List[UUID]](json)

    read shouldBe data
  }
}
