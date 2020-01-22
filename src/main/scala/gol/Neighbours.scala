package gol

case class Neighbours(cells: List[Cell]) {
  def aliveCount(): Int =
    cells.count {
      case Alive() => true
      case Dead()  => false
    }
}
