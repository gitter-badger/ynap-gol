package gol

sealed trait Cell {
  def evolve(neighbours: Neighbours): Cell =
    (this, neighbours.aliveCount) match {
      case (Alive(), 2 | 3) => Alive()
      case (Dead(), 3)      => Alive()
      case _                => Dead()
    }
}
case class Alive() extends Cell
case class Dead()  extends Cell
