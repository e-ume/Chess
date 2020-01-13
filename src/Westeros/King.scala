package Westeros

import Capabilities.Diagonal.{DiagonalDownLeft, DiagonalDownRight, DiagonalUpLeft, DiagonalUpRight}
import Capabilities.Sideways.{Leftward, Rightward}
import Capabilities.Straight.{StraightDown, StraightUp}
import Objects.MaxBlastRadius

class King(var xAxis: Int, var yAxis: Int) extends DiagonalUpLeft with DiagonalUpRight with DiagonalDownLeft with DiagonalDownRight
with StraightDown with StraightUp with Leftward with Rightward {

  private var superSet: Set[(Int, Int)] = Set()

  superSet = superSet ++ diagonalDownLeftComputeBlastRadius((xAxis,yAxis), (xAxis-1,yAxis-1) )
  superSet = superSet ++ diagonalDownRightComputeBlastRadius((xAxis,yAxis), (xAxis+1,yAxis-1))
  superSet = superSet ++ diagonalUpLeftComputeBlastRadius((xAxis,yAxis), (xAxis-1,yAxis+1))
  superSet = superSet ++ diagonalUpRightComputeBlastRadius((xAxis,yAxis), (xAxis+1,yAxis+1))
  //
  superSet = superSet ++ straightUPComputeBlastRadius((xAxis,yAxis), (xAxis,yAxis+1))
  superSet = superSet ++ straightDownComputeBlastRadius((xAxis,yAxis), (xAxis,yAxis-1))
  //
  superSet = superSet ++ leftwardComputeBlastRadius((xAxis,yAxis), (xAxis-1,yAxis) )
  superSet = superSet ++ rightwardComputeBlastRadius((xAxis,yAxis), (xAxis+1,yAxis) )

  val finalSet = superSet
}
