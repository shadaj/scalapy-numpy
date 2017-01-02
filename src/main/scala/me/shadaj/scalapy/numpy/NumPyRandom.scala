package me.shadaj.scalapy.numpy

import jep.Jep

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFascade

class NumPyRandom(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def randn(size: Int): NDArray[Double] = {
    dynamic.randn(size).as[NDArray[Double]]
  }

  def rand(size: Int): NDArray[Double] = {
    dynamic.rand(size).as[NDArray[Double]]
  }
}
