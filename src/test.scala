import Objects.{MaxBlastRadius, Point}
import Westeros.{Bishop, Knight, Queen}

object test {
  def main(args: Array[String]): Unit = {

    var s = diagonalDownLeftComputeBlastRadius((6,4), (6-1 ,4-1) )
    for (x <- s) {
      println(x._1 + " " + x._2)
    }
  }

  def diagonalDownLeftComputeBlastRadius(p: (Int, Int), MaxBlastRadius: (Int, Int)): Set[(Int, Int)] = {
    var s: Set[(Int, Int)] = Set()
    var tracker: (Int, Int) = (p._1, p._2) //Init with current point of object & tracks location

    while(tracker._1 >= MaxBlastRadius._1 && tracker._2 >= MaxBlastRadius._2) {
      s = s ++ Set(tracker)
      tracker = (tracker._1 - 1,tracker._2 - 1)
    }
    s
  }

}
