package BattleGround

import Objects.MaxBlastRadius
import Westeros.{Bishop, King, Knight, Queen}

import scala.util.Random

class Battleground(var m: Map[String,Int], var M: Int, var N: Int) {
  var kings = new Array[King](m.get("kings").get) //2 Kings
  var queens = new Array[Queen](m.get("queens").get) // 1 queen
  var bishops = new Array[Bishop](m.get("bishop").get)
  var knights = new Array[Knight](m.get("knight").get)

  def getPosition(): (Int, Int) = {
    (scala.util.Random.between(1, M + 1), scala.util.Random.between(1, N + 1))
  }

  def battle(): Unit ={
    if(kings.length != 0) {
      for (n <- 1 to kings.length) {
        val position = getPosition()
        kings(n) = new King(position._1,position._2)
      }
    }

    if(queens.length != 0) {
      for (n <- 1 to queens.length) {
        val position = getPosition()
        queens(n) = new Queen(position._1,position._2)
      }
    }

    if(bishops.length != 0) {
      for (n <- 1 to bishops.length) {
        val position = getPosition()
        bishops(n) = new Bishop(position._1,position._2)
      }
    }

    if(knights.length != 0) {
      for (n <- 1 to knights.length) {
        val position = getPosition()
        knights(n) = new Knight(position._1,position._2)
      }
    }

  }

  def outcome(): {}
  def checkCasualties(): {}
}

object Battleground {
  val battles = 10
  var battle = 0
  def main(args: Array[String]): Unit = {
    var map :Map[String,Int] = Map()
    var M = 7
    var N = 7

    while (battle < battles) {
      val dimension = MaxBlastRadius(M,N)
      var battleground = new Battleground(map, M, N)
      println(battle)
      battle = battle + 1
    }

  }
}