package me.shadaj.scalapy.numpy

import me.shadaj.scalapy.py

import org.scalatest.FunSuite

class NumPyLinalgSuite extends FunSuite {
  test("Can calculate the inverse of a matrix") {
    py.local {
      val np = py.module("numpy").as[NumPy]
      val mat = np.array[Double](Seq(
        Seq(1, 2),
        Seq(3, 4)
      ))

      // TODO(shadaj): lots of weird behavior with NDArrays for both JVM and native
      assert(np.linalg.inv(mat).tolist.as[Seq[Seq[Double]]].zip(Seq(
        Seq(-2.0, 1.0),
        Seq(1.5, -0.5)
      )).forall { case (ra, rb) => 
        ra.zip(rb).forall { case (e1, e2) =>
          math.abs(e1 - e2) < 0.000001
        }
      })
    }
  }
}
