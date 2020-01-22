package gol

import org.scalatest.funsuite.AnyFunSuite

class TextParserTests extends AnyFunSuite {

  test("single live cell") {
    val world = World.parse("""
      X
      """)
    assert(
      world == World(
        Map(
          (Position(0, 0) -> Alive())
        )
      )
    )
  }

}
