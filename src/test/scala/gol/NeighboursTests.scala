package gol

import org.scalatest.funsuite.AnyFunSuite

class NeighboursTests extends AnyFunSuite {

  test("count alive cells") {
    val neighbours = Neighbours(List(Alive(), Dead(), Alive()))
    val result     = neighbours.aliveCount()
    assert(result == 2)
  }

}
