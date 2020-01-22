package gol

import org.scalatest.funsuite.AnyFunSuite

class AcceptanceTests extends AnyFunSuite {

  test("single live cell, die after generation") {
    val world = World.parse("""X""")
    val w1    = world.evolve()
    assert(w1.render() == """
                            |_
                            |""".stripMargin)
  }

}
