package gol

case class World(cells: Map[Position, Cell]) {

  def evolve(): World =
    World(cells.map {
      case (position, cell) => position -> cell.evolve(neighboursFor(position))
    })

  def seed(position: Position, cell: Alive): World =
    World(cells + (position -> cell))

  def render(): String =
    // NOTE: to be completed
    s"""
       |${cells.values.map(_ => '_').mkString}
       |""".stripMargin

  private def neighboursFor(me: Position): Neighbours =
    Neighbours(me.neighbours().map(p => cells.getOrElse(p, Dead())))

}

object World {

  def parse(input: String): World =
    // NOTE: to be completed
    input
      .filter(s => s == 'X')
      .zipWithIndex
      .map {
        case (_, idx) => idx -> Alive()
      }
      .foldLeft(new World(Map())) {
        case (world, (idx, cell)) => world.seed(Position(idx, idx), cell)
      }
}
