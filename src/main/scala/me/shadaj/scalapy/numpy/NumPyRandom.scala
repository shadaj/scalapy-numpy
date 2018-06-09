package me.shadaj.scalapy.numpy

import jep.Jep

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class NumPyRandom(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def randn(size: Int): NDArray[Double] = {
    native
  }

  def rand(size: Int): NDArray[Double] = {
    native
  }
}
