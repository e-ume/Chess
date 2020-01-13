package Capabilities

trait LShaped {
  def computeBlastRadius(p: (Int, Int)): Set[(Int, Int)] = {
    var s: Set[(Int, Int)] = Set()
    var s2: Set[(Int, Int)] = Set()

    s = s ++ Set( (p._1 + 2, p._2 + 1) )
    s = s ++ Set( (p._1 + 2, p._2 - 1) )
    s = s ++ Set( (p._1 + 1, p._2 + 2) )
    s = s ++ Set( (p._1 + 1, p._2 - 2) )
    s = s ++ Set( (p._1 - 2, p._2 - 1) )
    s = s ++ Set( (p._1 - 2, p._2 + 1) )
    s = s ++ Set( (p._1 - 1, p._2 + 2) )
    s = s ++ Set( (p._1 - 1, p._2 - 2) )

    for ( x <- s) {
      if(x._1 <= 7 && x._2 <= 7 && x._1 >= 1 && x._2 >= 1 ) {
        s2 = s2 + x
      }
    }
    s2
  }
}
