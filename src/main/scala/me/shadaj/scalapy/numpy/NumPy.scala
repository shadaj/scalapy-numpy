package me.shadaj.scalapy.numpy

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectFacade, ObjectReader, ObjectWriter}

import scala.reflect.ClassTag

class NumPy(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o) {
  def asarray[T: ClassTag](s: Seq[T])(implicit writer: ObjectWriter[T], reader: ObjectReader[T]): NDArray[T] = {
    toDynamic.asarray(s).as[NDArray[T]]
  }

  def matrix[T: ClassTag](s: Seq[T])(implicit writer: ObjectWriter[T], reader: ObjectReader[T]): NDArray[T] = {
    toDynamic.matrix(s).as[NDArray[T]]
  }

  def resize[T: ClassTag](s: Seq[T], shape: (Int, Int))(implicit writer: ObjectWriter[T], reader: ObjectReader[T]): NDArray[NDArray[Double]] = {
    toDynamic.resize(s, shape).as[NDArray[NDArray[Double]]]
  }

  def ones(size: Int): NDArray[Double] = {
    native
  }

  def zeroes(size: Int): NDArray[Double] = {
    native
  }

  def random: NumPyRandom = native

  def float32: NumPyType = native

  def linalg: NumPyLinalg = native

  def clip[T](value: NDArray[T], low: NDArray[T], high: NDArray[T])(implicit writer: ObjectWriter[T], reader: ObjectReader[T]): NDArray[T] = {
    toDynamic.clip(value, low, high).as[NDArray[T]]
  }
}
