package org.example

import cps.*
import cps.monads.{*, given}

import scala.collection.View

object Tour:

  def find(m: Int, n: Int): View[Board] =
    for
      position <- startPosition(m, n).view
      board <- Board(m, n).updateIn(position).view
      tour <- inner(position, board)
    yield tour

  private def inner(position: Position, board: Board): View[Board] =
    if (board.isFilled) Seq(board).view
    else Knight.steps(position, board).view.collect {
      case (position, board) => inner(position, board)
    }.flatten
    

  // LMAO
  private def startPosition(m: Int, n: Int): Seq[Position] = reify[Seq] {
    Position(reflect(Seq.range(0, m)), reflect(Seq.range(0, n)))
  }