package me.shadaj.scalapy.numpy

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{Reader, Writer}

import scala.reflect.ClassTag

@py.native trait NumPy extends py.Object {
  def asarray[T: ClassTag](s: Seq[T])(implicit writer: Writer[T], reader: Reader[T]): NDArray[T] = {
    as[py.Dynamic].asarray(s).as[NDArray[T]]
  }

  def array[T: ClassTag](s: Seq[Seq[T]])(implicit writer: Writer[Seq[Seq[T]]], reader: Reader[T]): NDArray[NDArray[T]] = {
    as[py.Dynamic].matrix(s).as[NDArray[NDArray[T]]]
  }

  def matrix[T: ClassTag](s: Seq[T])(implicit writer: Writer[T], reader: Reader[T]): NDArray[T] = {
    as[py.Dynamic].matrix(s).as[NDArray[T]]
  }

  def resize[T: ClassTag](s: Seq[T], shape: (Int, Int))(implicit writer: Writer[T], reader: Reader[T]): NDArray[NDArray[T]] = {
    as[py.Dynamic].resize(s, shape).as[NDArray[NDArray[T]]]
  }

  def ones(size: Int): NDArray[Double] = py.native

  def zeroes(size: Int): NDArray[Double] = py.native

  def random: NumPyRandom = py.native

  def float32: NumPyType = py.native

  def linalg: NumPyLinalg = py.native

  def clip[T](value: NDArray[T], low: NDArray[T], high: NDArray[T])(implicit writer: Writer[T], reader: Reader[T]): NDArray[T] = {
    as[py.Dynamic].clip(value, low, high).as[NDArray[T]]
  }
}
