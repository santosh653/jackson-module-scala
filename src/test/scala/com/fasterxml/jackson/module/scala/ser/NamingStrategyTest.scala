package com.fasterxml.jackson
package module.scala
package ser

import java.io.ByteArrayOutputStream

import com.fasterxml.jackson.databind.{ObjectMapper, PropertyNamingStrategy}
import com.google.common.base.Optional
import org.scalatest.Outcome
import org.scalatest.flatspec.FixtureAnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.beans.BeanProperty

class PojoWrittenInScala {
  @BeanProperty var optFoo: Optional[String] = Optional.absent()
  @BeanProperty var bar: Int = 0
}


class NamingStrategyTest extends FixtureAnyFlatSpec with Matchers {

  type FixtureParam = ObjectMapper

  protected def withFixture(test: OneArgTest): Outcome = {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
    test(mapper)
  }

  "DefaultScalaModule" should "correctly handle naming strategies" in { mapper =>
    val bytes = new ByteArrayOutputStream()
    mapper.writeValue(bytes, new PojoWrittenInScala)
  }
}
