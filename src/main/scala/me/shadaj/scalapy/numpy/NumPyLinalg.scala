package me.shadaj.scalapy.numpy

import me.shadaj.scalapy.py

@py.native trait NumPyLinalg extends py.Object {
  def inv(arr: NDArray[NDArray[Double]]): NDArray[NDArray[Double]] = py.native
}
