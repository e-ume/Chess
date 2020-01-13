import Objects.MaxBlastRadius
import Westeros.{Bishop, King, Knight, Queen}

object test {
  def main(args: Array[String]): Unit = {
    var k = new Queen(4,4)
    //var s = leftwardComputeBlastRadius((6,4), (6-1 ,4) )
    println("size: " + k.finalSet.size )
    for (x <- k.finalSet) {
      println(x._1 + " " + x._2)
    }
  }

  def leftwardComputeBlastRadius(p: (Int, Int), MaxBlastRadius: (Int, Int)): Set[(Int, Int)] = {
    var s: Set[(Int, Int)] = Set()
    var tracker: (Int, Int) = (p._1, p._2) //Init with current point of object & tracks location

    while(tracker._1 >= MaxBlastRadius._1) {
      s = s ++ Set(tracker)
      tracker = (tracker._1 - 1,tracker._2)
    }
    s
  }

}
