package me.shadaj.scalapy.numpy

import jep.Jep

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.ObjectFascade

class NumPyType(o: py.Object)(implicit jep: Jep) extends ObjectFascade(o)
