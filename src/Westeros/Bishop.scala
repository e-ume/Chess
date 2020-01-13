package Westeros

import Capabilities.Diagonal.{DiagonalDownLeft, DiagonalDownRight, DiagonalUpLeft, DiagonalUpRight}
import Objects.MaxBlastRadius

class Bishop (var xAxis: Int, var yAxis: Int ) extends DiagonalDownLeft with DiagonalDownRight with DiagonalUpRight with DiagonalUpLeft {
  private var superSet: Set[(Int, Int)] = Set()
  superSet = superSet ++ diagonalDownLeftComputeBlastRadius((xAxis,yAxis), MaxBlastRadius.LowerLeft)
  superSet = superSet ++ diagonalDownRightComputeBlastRadius((xAxis,yAxis), MaxBlastRadius.LowerRight)
  superSet = superSet ++ diagonalUpLeftComputeBlastRadius((xAxis,yAxis), MaxBlastRadius.UpperLeft)
  superSet = superSet ++ diagonalUpRightComputeBlastRadius((xAxis,yAxis), MaxBlastRadius.UpperRight)

  val finalSet = superSet
}
