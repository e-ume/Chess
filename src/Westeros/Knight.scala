package Westeros

import Capabilities.Knight.LShaped

class Knight(var xAxis: Int, var yAxis: Int ) extends LShaped{
  private var superSet = lShapedComputeBlastRadius(xAxis,yAxis)
  val finalSet = superSet
}
