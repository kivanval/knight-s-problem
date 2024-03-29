package org.example

class Board private[example](val field: Seq[Seq[Option[Int]]], m: Int, n: Int, stepNumber: Int):
  private def inBoard(position: Position): Boolean =
    position.m < m && position.n < n && position.m >= 0 && position.n >= 0

  private def freeSquare(position: Position): Boolean =
    inBoard(position) && field(position.m)(position.n).isEmpty

  def updateIn(position: Position): Option[Board] =
    if freeSquare(position)
    then Some(new Board(
      field.updated(position.m,
        field(position.m)
          .updated(position.n,
            Some(stepNumber))),
      m, n,
      stepNumber + 1
    ))
    else None

  val isFilled: Boolean = field.flatten.forall(_.isDefined)

object Board:
  def apply(m: Int, n: Int): Board = new Board(Seq.fill(m, n)(None), m, n, 0)

  def apply(m: Int): Board = new Board(Seq.fill(m, m)(None), m, m, 0)

