package me.shadaj.scalapy.numpy

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class NumPyLinalg(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def inv(arr: NDArray[Double]): NDArray[Double] = native
}
