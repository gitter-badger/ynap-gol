package gol

import org.scalatest.funsuite.AnyFunSuite

class CellTests extends AnyFunSuite {

  test("A live cell with fewer than two live neighbours dies, by under population") {
    val cell       = Alive()
    val neighbours = Neighbours(List(Dead(), Alive(), Dead()))
    val result     = cell.evolve(neighbours)
    assert(result == Dead())
  }

  test("A live cell with more than three live neighbours dies, by overcrowding") {
    val cell       = Alive()
    val neighbours = Neighbours(List(Alive(), Alive(), Alive(), Alive(), Alive(), Alive()))
    val result     = cell.evolve(neighbours)
    assert(result == Dead())
  }

  test("A live cell with two or three live neighbour’s lives on to the next generation") {
    val cell = Alive()
    assert(cell.evolve(Neighbours(List(Alive(), Alive()))) == Alive())
    assert(cell.evolve(Neighbours(List(Alive(), Alive(), Alive()))) == Alive())
  }

  test("A dead cell with exactly three live neighbours becomes a live cell") {
    val cell       = Dead()
    val neighbours = Neighbours(List(Alive(), Alive(), Alive()))
    assert(cell.evolve(neighbours) == Alive())
  }

  test("A dead cell without exactly three live neighbours stay dead") {
    val cell       = Dead()
    val neighbours = Neighbours(List(Alive(), Alive()))
    assert(cell.evolve(neighbours) == Dead())
  }

}
