class Board private(
                     val field: List[List[Option[Int]]],
                     val m: Int, val n: Int,
                     val stepNumber: Int):
  private def inBoard(position: Position): Option[Position] =
    if position.m < m && position.n < n
    then Option(position)
    else None

  private def freeSquare(position: Position): Boolean =
    (for
      Position(m, n) <- inBoard(position)
      stepNumber <- field(m)(n)
    yield stepNumber).isEmpty

  def updatePosition(position: Position): Option[Board] =
    if freeSquare(position)
    then Some(new Board(
      field.updated(position.m, field(position.m).updated(n, Some(stepNumber))),
      m, n,
      stepNumber + 1
    ))
    else None

object Board:
  def apply(m: Int, n: Int): Board = new Board(List.fill(m, n)(None), m, n, 1)

  def apply(m: Int): Board = new Board(List.fill(m, m)(None), m, m, 1)

