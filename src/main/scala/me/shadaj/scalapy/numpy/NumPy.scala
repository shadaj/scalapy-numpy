package me.shadaj.scalapy.numpy

import jep.Jep

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFascade, ObjectReader, ObjectWriter}

class NumPy(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o) {
  def asarray[T](s: Seq[T])(implicit writer: ObjectWriter[T], reader: ObjectReader[T]): NDArray[T] = {
    dynamic.asarray(s).as[NDArray[T]]
  }

  def resize[T](s: Seq[T], shape: (Int, Int))(implicit writer: ObjectWriter[T], reader: ObjectReader[T]): NDArray[NDArray[Double]] = {
    dynamic.resize(s, shape).as[NDArray[NDArray[Double]]]
  }

  def ones(size: Int): NDArray[Double] = {
    dynamic.ones(size).as[NDArray[Double]]
  }

  def random: NumPyRandom = dynamic.random.as[NumPyRandom]

  def float32: NumPyType = dynamic.float32.as[NumPyType]

  def clip[T](value: NDArray[T], low: NDArray[T], high: NDArray[T])(implicit writer: ObjectWriter[T], reader: ObjectReader[T]): NDArray[T] = {
    dynamic.clip(value, low, high).as[NDArray[T]]
  }
}
