package BattleGround

import Objects.MaxBlastRadius
import Westeros.{Bishop, King, Knight, Queen}

import scala.util.Random

class Battleground(var m: Map[String,Int], var M: Int, var N: Int) {
  var kings = new Array[(King, (Int,Int) )](m.get("kings").get) //2 Kings
  var queens = new Array[(Queen, (Int,Int) )](m.get("queens").get) // 1 queen
  var bishops = new Array[(Bishop, (Int,Int) )](m.get("bishop").get)
  var knights = new Array[(Knight, (Int,Int) )](m.get("knight").get)

  var fighterLocationSet = Set()
  var blastRadiusSet = Set()
  var noOfFighters = kings.length + queens.length + bishops.length + knights.length

  def getPosition(): (Int, Int) = {
    (scala.util.Random.between(1, M + 1), scala.util.Random.between(1, N + 1))
  }

  def battle(): Unit ={
    if(kings.length != 0) {
      for (n <- 1 to kings.length) {
        val position = getPosition()
        kings(n) = (new King(position._1,position._2), position)
        fighterLocationSet = fighterLocationSet ++ Set( position )
        blastRadiusSet = blastRadiusSet ++ Set( kings(n)._1.finalSet )
      }
    }

    if(queens.length != 0) {
      for (n <- 1 to queens.length) {
        val position = getPosition()
        queens(n) = (new Queen(position._1,position._2), position)
        fighterLocationSet = fighterLocationSet ++ Set( position )
        blastRadiusSet = blastRadiusSet ++ Set( queens(n)._1.finalSet )
      }
    }

    if(bishops.length != 0) {
      for (n <- 1 to bishops.length) {
        val position = getPosition()
        bishops(n) = (new Bishop(position._1,position._2), position)
        fighterLocationSet = fighterLocationSet ++ Set( position )
        blastRadiusSet = blastRadiusSet ++ Set( bishops(n)._1.finalSet )
      }
    }

    if(knights.length != 0) {
      for (n <- 1 to knights.length) {
        val position = getPosition()
        knights(n) = (new Knight(position._1,position._2), position)
        fighterLocationSet = fighterLocationSet ++ Set( position )
        blastRadiusSet = blastRadiusSet ++ Set( knights(n)._1.finalSet )
      }
    }

  }

  def casualties(): Boolean = {
    //Just in case 2 fighters land on the same position.
    var casualties =  true
    //noOfFighters: Each fighter is assumed to have been in a distinct location
    if( (noOfFighters + blastRadiusSet.size)  == (fighterLocationSet ++ blastRadiusSet).size  ){
      casualties = false
    }
    casualties
  }
}

object Battleground {
  val battles = 10
  var battle = 0
  def main(args: Array[String]): Unit = {
    var map :Map[String,Int] = Map()
    var M = 7
    var N = 7

    var counter = 0

    while (battle < battles) {
      val dimension = MaxBlastRadius(M,N)
      val battleground = new Battleground(map, M, N)
      battleground.battle()
      if (battleground.casualties() == false) {
        counter = counter + 1
      }

      battle = battle + 1
    }

  }
}