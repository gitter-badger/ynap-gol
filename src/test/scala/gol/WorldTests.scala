package gol

import org.scalatest.funsuite.AnyFunSuite

class WorldTests extends AnyFunSuite {

  test("a world can be seeded") {
    val world = World(Map())
    val w1 = world
      .seed(Position(1, 1), Alive())
      .seed(Position(2, 2), Alive())
    assert(
      w1 == World(
        Map(
          (Position(1, 1) -> Alive()),
          (Position(2, 2) -> Alive())
        )
      )
    )
  }

  test("single live cell, die after generation") {
    val world = World(Map())
    val w1    = world.seed(Position(1, 1), Alive()).evolve()
    assert(
      w1 == World(
        Map(
          (Position(1, 1) -> Dead())
        )
      )
    )
  }

  test("render all dead cells") {

    val world = World(
      Map(
        (Position(1, 1) -> Dead()),
        (Position(2, 2) -> Dead())
      )
    )
    val result = world.render()
    assert(result == """
                       |__
                       |""".stripMargin)
  }

  test("Block pattern") {
    val world = World(
      Map(
        (Position(1, 1) -> Alive()),
        (Position(2, 1) -> Alive()),
        (Position(1, 2) -> Alive()),
        (Position(2, 2) -> Alive())
      )
    )
    val result = world.evolve()
    assert(
      result ==
        World(
          Map(
            (Position(1, 1) -> Alive()),
            (Position(2, 1) -> Alive()),
            (Position(1, 2) -> Alive()),
            (Position(2, 2) -> Alive())
          )
        )
    )
  }

  test("Blinker pattern") {
    val world = World(
      Map(
        (Position(0, 0) -> Dead()),
        (Position(1, 0) -> Dead()),
        (Position(2, 0) -> Dead()),
        (Position(0, 1) -> Alive()),
        (Position(1, 1) -> Alive()),
        (Position(2, 1) -> Alive()),
        (Position(0, 2) -> Dead()),
        (Position(1, 2) -> Dead()),
        (Position(2, 2) -> Dead())
      )
    )
    val result = world.evolve()
    assert(
      result ==
        World(
          Map(
            (Position(0, 0) -> Dead()),
            (Position(1, 0) -> Alive()),
            (Position(2, 0) -> Dead()),
            (Position(0, 1) -> Dead()),
            (Position(1, 1) -> Alive()),
            (Position(2, 1) -> Dead()),
            (Position(0, 2) -> Dead()),
            (Position(1, 2) -> Alive()),
            (Position(2, 2) -> Dead())
          )
        )
    )
  }

}
