package gol

case class Position(x: Int, y: Int) {
  def neighbours(): List[Position] =
    List(
      Position(x - 1, y - 1),
      Position(x, y - 1),
      Position(x + 1, y - 1),
      Position(x - 1, y),
      Position(x + 1, y),
      Position(x - 1, y + 1),
      Position(x, y + 1),
      Position(x + 1, y + 1)
    )
}
