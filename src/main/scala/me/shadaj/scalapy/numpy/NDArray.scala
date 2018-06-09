package me.shadaj.scalapy.numpy

import jep.Jep
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.{ObjectReader, ObjectWriter, ValueAndRequestObject}

class NDArray[T](orig: py.Object)(implicit reader: ObjectReader[T], jep: Jep) extends py.Object(orig.variableId) with Seq[T] {
  private val origDynamic = orig.asInstanceOf[py.DynamicObject]

  def unary_-(): NDArray[T] = (-origDynamic).as[NDArray[T]]

  def +(o: T)(implicit writer: ObjectWriter[T]): NDArray[T] = (origDynamic + o).as[NDArray[T]]
  def +(o: NDArray[T])(implicit writer: ObjectWriter[NDArray[T]]): NDArray[T] = (origDynamic + o).as[NDArray[T]]

  def -(o: T)(implicit writer: ObjectWriter[T]): NDArray[T] = (origDynamic - o).as[NDArray[T]]
  def -(o: NDArray[T])(implicit writer: ObjectWriter[NDArray[T]]): NDArray[T] = (origDynamic - o).as[NDArray[T]]

  def *(o: T)(implicit writer: ObjectWriter[T]): NDArray[T] = (origDynamic * o).as[NDArray[T]]
  def *(o: NDArray[T])(implicit writer: ObjectWriter[NDArray[T]]): NDArray[T] = (origDynamic * o).as[NDArray[T]]

  def /(o: T)(implicit writer: ObjectWriter[T]): NDArray[T] = (origDynamic / o).as[NDArray[T]]
  def /(o: NDArray[T])(implicit writer: ObjectWriter[NDArray[T]]): NDArray[T] = (origDynamic / o).as[NDArray[T]]

  def T(implicit writer: ObjectWriter[T]): NDArray[T] = origDynamic.T.as[NDArray[T]]

  def astype(newType: NumPyType): NDArray[T] = origDynamic.astype(newType).as[NDArray[T]]

  override def length: Int = py.global.len(orig).as[Int]

  override def apply(idx: Int): T = origDynamic.arrayAccess(idx).as[T]

  override def iterator: Iterator[T] = (0 until length).toIterator.map(apply)
}

object NDArray {
  implicit def seqReader[T](implicit reader: ObjectReader[T]): ObjectReader[NDArray[T]] = new ObjectReader[NDArray[T]] {
    override def read(r: ValueAndRequestObject)(implicit jep: Jep): NDArray[T] = new NDArray[T](r.requestObject)(reader, jep)
  }
}
