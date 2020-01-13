package Capabilities.Sideways

trait Leftward {
  def computeBlastRadius(p: (Int, Int), MaxBlastRadius: (Int, Int)): Set[(Int, Int)] = {
    var s: Set[(Int, Int)] = Set()
    var tracker: (Int, Int) = (p._1, p._2) //Init with current point of object & tracks location

    while(tracker._1 >= MaxBlastRadius._1) {
      s = s ++ Set(tracker)
      tracker = (tracker._1 - 1,tracker._2)
    }
    s
  }

}
