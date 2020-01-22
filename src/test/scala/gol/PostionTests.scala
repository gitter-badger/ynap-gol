package gol

import org.scalatest.funsuite.AnyFunSuite

class PositionTests extends AnyFunSuite {

  test("compute neigbours positions") {
    val position = Position(1, 1)
    val result   = position.neighbours()
    assert(
      result == List(
        Position(0, 0),
        Position(1, 0),
        Position(2, 0),
        Position(0, 1),
        Position(2, 1),
        Position(0, 2),
        Position(1, 2),
        Position(2, 2)
      )
    )
  }
}
