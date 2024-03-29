package org.example

import cps.*
import cps.monads.{*, given}

object Knight:

  private val steps: Seq[Seq[Int]] = Seq(
    Seq(2, 1), Seq(2, -1),
    Seq(-2, 1), Seq(-2, -1),
    Seq(1, 2), Seq(1, -2),
    Seq(-1, 2), Seq(-1, -2)
  )

  def steps(position: Position, board: Board): Seq[(Position, Board)] = reify[Seq] {
    val Seq(m, n) = reflect(steps)
    val step = position.copy(position.m + m, position.n + n)
    reflect(board.updateIn(step).map(step -> _).toSeq)
  }


