package com.hh.robot

import com.hh.garden.Field
import com.hh.physics.CardinalHelper

open class Machine(private val f:Field) {

    var currentFacingSide: String = ""

    fun move(){
        var x: Int = this.getPos().substring(4).toInt()
        var y: Int = this.getPos().substring(1).toInt()

        when(this.getFacingSide()) {
            CardinalHelper.NORTH -> { f.field[x][y] = f.field[x][y + 1] }
            CardinalHelper.SOUTH -> { f.field[x][y] = f.field[x][y - 1] }
            CardinalHelper.EAST -> { f.field[x][y] = f.field[x + 1][y] }
            CardinalHelper.WEST -> { f.field[x][y] = f.field[x - 1][y] }
        }
    }

    fun rotateTo(){
        when(currentFacingSide) {

        }
    }

    fun setPos(posX: Int, posY: Int){
        while(posX > (f.rows - 1) || posY > (f.columns -1)){
            println("Posicao invalida!!")
        }

        f.field[posX][posY] = this.currentFacingSide
    }

    fun getPos(): String{
        var pos = ""
        for((i, r) in f.field.withIndex()){
            var j = 0
            for(c in r){
                if(f.field[i][j] == this.currentFacingSide){
                    pos = String.format("(%d, %d)", i, j)
                }
            }
        }
        return pos
    }

    fun setFacingSide(pos: CardinalHelper): String {
        when (pos) {
            CardinalHelper.NORTH -> { this.currentFacingSide = "^"; return "^" }
            CardinalHelper.SOUTH -> { this.currentFacingSide = "v"; return "v" }
            CardinalHelper.EAST -> { this.currentFacingSide = ">"; return ">" }
            CardinalHelper.WEST -> { this.currentFacingSide = "<"; return "<" }
            else -> { this.currentFacingSide = "^"; return "^" }
        }
    }

    private fun getFacingSide(): CardinalHelper{
        when(currentFacingSide) {
            "^" -> { return CardinalHelper.NORTH }
            "v" -> { return CardinalHelper.SOUTH}
            ">" -> { return CardinalHelper.EAST}
            "<" -> { return CardinalHelper.WEST}
            else -> { return CardinalHelper.NORTH}
        }
    }
}