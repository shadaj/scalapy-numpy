package me.shadaj.scalapy.numpy

import me.shadaj.scalapy.py

@py.native trait NumPyRandom extends py.Object {
  def randn(size: Int): NDArray[Double] = py.native

  def rand(size: Int): NDArray[Double] = py.native
}
