package org.example

import munit.FunSuite

class BoardTest extends FunSuite {
  test("update in the free square") {
    val maybeBoard = Board(2).updateIn(Position(0, 0))

    assert(maybeBoard.isDefined)

    val position = maybeBoard.get.field.head.head

    assert(position.isDefined)
    assert(position.get == 0)
  }
  test("does not update in the occupied square") {
    val maybeBoard = new Board(Seq(Seq(Some(3))), 1, 1, 4).updateIn(Position(0, 0))

    assert(maybeBoard.isEmpty)
  }
}
