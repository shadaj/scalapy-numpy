# scalapy-numpy
Static facades for using NumPy in ScalaPy. Currently contains minimal bindings for usage with TensorFlow.

## Building
First, [build Jep](https://github.com/mrj0/jep/wiki/Getting-Started) and place your jep-*.jar, jep.so, and libjep.jnilib files in the `lib/` folder for SBT to pick them up. If you do not have a libjep.jnilib file, copy the jep.so file and rename it to libjep.jnilib. These files will need to be included in the same manner for building any project that depends on ScalaPy.

When you are running, you may need to provide a path to your libraries when launching SBT by using a command such as `sbt -Djava.library.path=/your/path/to/lib/`.

