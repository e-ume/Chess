package BattleGround

import Objects.MaxBlastRadius
import Westeros.{Bishop, King, Knight, Queen}

class Battleground(var m: Map[String,Int], var M: Int, var N: Int) {
  var kings = new Array[(King, (Int,Int) )](m.get("kings").get) //2 Kings
  var queens = new Array[(Queen, (Int,Int) )](m.get("queens").get) // 1 queen
  var bishops = new Array[(Bishop, (Int,Int) )](m.get("bishop").get)
  var knights = new Array[(Knight, (Int,Int) )](m.get("knight").get)

  var fighterLocationSet: Set[(Int,Int)] = Set()
  var blastRadiusSet: Set[(Int,Int)]  = Set()
  var noOfFighters = kings.length + queens.length + bishops.length + knights.length

  def getPosition(): (Int, Int) = {
    (scala.util.Random.between(1, M + 1), scala.util.Random.between(1, N + 1))
  }

  def battle(): Unit = {
    if(kings.length > 0){
      var i = 0
      while( i < kings.length ){
        val coordinates = getPosition()
        kings(i) = (new King(coordinates._1, coordinates._2), coordinates )
        fighterLocationSet = fighterLocationSet ++ Set(coordinates)
        blastRadiusSet = blastRadiusSet ++ kings(i)._1.finalSet
        i = i + 1

      }
    }

    if(queens.length > 0){
      var i = 0
      while( i < queens.length ){
        val coordinates = getPosition()
        queens(i) = (new Queen(coordinates._1, coordinates._2), coordinates )
        fighterLocationSet = fighterLocationSet ++ Set(coordinates)
        blastRadiusSet = blastRadiusSet ++ queens(i)._1.finalSet
        i = i + 1
      }
    }

    if(bishops.length > 0){
      var i = 0
      while( i < bishops.length ){
        val coordinates = getPosition()
        bishops(i) = (new Bishop(coordinates._1, coordinates._2), coordinates )
        fighterLocationSet = fighterLocationSet ++ Set(coordinates)
        blastRadiusSet = blastRadiusSet ++ bishops(i)._1.finalSet
        i = i + 1
      }
    }

    if(knights.length > 0){
      var i = 0
      while( i < knights.length ){
        val coordinates = getPosition()
        knights(i) = (new Knight(coordinates._1, coordinates._2), coordinates )
        fighterLocationSet = fighterLocationSet ++ Set(coordinates)
        blastRadiusSet = blastRadiusSet ++ knights(i)._1.finalSet
        i = i + 1
      }
    }
  }

  def casualties(): Boolean = {
    var superDuperSet = blastRadiusSet ++ fighterLocationSet
    var bool = false
    if (superDuperSet.size != (blastRadiusSet.size + fighterLocationSet.size) ) {
      //if these don't match, then there are casualties. (i.e Overlap)
      println(superDuperSet.size)
      println( (blastRadiusSet.size + fighterLocationSet.size))
      bool = true
    }
    bool
  }
}

object Battleground {
  val battles = 10
  var battle = 0

  def main(args: Array[String]): Unit = {
    var m: Map[String,Int] = Map()
    m = m ++ Map("kings" -> 2)
    m = m ++ Map("queens" -> 2)
    m = m ++ Map("bishop" -> 1)
    m = m ++ Map("knight" -> 1)

    var M = 7
    var N = 7

    var battleground = new Battleground(m, M, N)
    battleground.battle()
    println(battleground.casualties())
    println("fighterLocationSet Size: " + battleground.fighterLocationSet.size)
    println("blastRadiusSet Size: " + battleground.blastRadiusSet.size)
    println("noOfFighters Size: " + battleground.noOfFighters )

  }
}