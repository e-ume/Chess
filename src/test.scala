import Objects.Point

object test {
  def main(args: Array[String]): Unit = {
    val outcome = computeBlastRadius((5,3), (7,3))
    println("There are " + outcome.size + " items" )
    for(x <- outcome) {
      println(x._1 + " " + x._2)
    }
  }

  def computeBlastRadius(p: (Int, Int), MaxBlastRadius: (Int, Int)): Set[(Int, Int)] = {
    var s: Set[(Int, Int)] = Set()
    var tracker: (Int, Int) = (p._1, p._2) //Init with current point of object & tracks location

    while(tracker._1 <= MaxBlastRadius._1) {
      s = s ++ Set(tracker)
      tracker = (tracker._1 + 1, tracker._2)
    }
    s
  }

}
