package org.example

import munit.FunSuite

class TourTest extends FunSuite {
  test("tour 5 x 5") {
    assert(Tour.find(5, 5).sizeIs == 1728)
  }
}
