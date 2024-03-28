object Knight:

  private val steps = List(-2, -1, 1, 2).combinations(2).toSeq
  def steps(position: Position, board: Board): Seq[Board] =
    for
      Seq(m, n) <- steps
      board <- board.updatePosition(position.copy(position.m + m, position.n + n))
    yield board
  

