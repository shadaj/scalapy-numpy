package me.shadaj.scalapy.numpy

import jep.Jep

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFacade

class NumPyType(o: py.Object)(implicit jep: Jep) extends ObjectFacade(o)
