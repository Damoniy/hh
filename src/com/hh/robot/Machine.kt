package com.hh.robot

import com.hh.garden.Field
import com.hh.main.Commands
import com.hh.physics.CardinalHelper

open class Machine(val f:Field) {

    private var currentFacingSide: String = ""
    private var position = ""

    val cmd = Commands(f, this as WateringBot)

    fun travelTo(x: Int, y: Int) {
        val pos = this.getPos()
        val cX: Int = pos.substring(1, 2).toInt()
        val cY: Int = pos.substring(4, 5).toInt()

        if(this.getFacingSide() == CardinalHelper.NORTH)
        {
            if (x > cX) {
                cmd.execute("D")
                cmd.execute("D")
                for(i in 0 until x - cX) {
                    cmd.execute("M")
                }
            }
            if ( x < cX) {
                for(i in 0 until cX - x) {
                    cmd.execute("M")
                }
            }
            if (y > cY) {
                cmd.execute("D")
                    for(i in 0 until y - cY) {
                        cmd.execute("M")
                    }
            }
            if (y < cY) {
                cmd.execute("E")
                    for(i in 0 until cY - y) {
                        cmd.execute("M")
                    }
            }
        } else if (this.getFacingSide() == CardinalHelper.EAST) {
            if(x > cX) {
                cmd.execute("D")
                for(i in 0 until x - cX) {
                    cmd.execute("M")
                }
            }

            if(x < cX) {
                cmd.execute("E")
                for(i in 0 until cX - x) {
                    cmd.execute("M")
                }
            }

            if(y > cY) {
                for(i in 0 until y - cY) {
                    cmd.execute("M")
                }
            }

            if(y < cY) {
                cmd.execute("D")
                cmd.execute("D")
                for(i in 0 until cY - y) {
                    cmd.execute("M")
                }
            }
        } else if (this.getFacingSide() == CardinalHelper.WEST) {
            if(x > cX) {
                cmd.execute("E")
                for(i in 0 until x - cX) {
                    cmd.execute("M")
                }
            }

            if(x < cX) {
                cmd.execute("D")
                for(i in 0 until cX - x) {
                    cmd.execute("M")
                }
            }

            if (y > cY) {
                cmd.execute("D")
                cmd.execute("D")
                for(i in 0 until y - cY) {
                    cmd.execute("M")
                }
            }

            if(y < cY) {
                for(i in 0 until cY - y) {
                    cmd.execute("M")
                }
            }
        } else {
            if(x > cX) {
                for(i in 0 until x - cX) {
                    cmd.execute("M")
                }
            }

            if(x < cX) {
                cmd.execute("D")
                cmd.execute("D")
                for(i in 0 until cX - x) {
                    cmd.execute("M")
                }
            }

            if (y > cY) {
                cmd.execute("E")
                for(i in 0 until y - cY) {
                    cmd.execute("M")
                }
            }

            if(y < cY) {
                cmd.execute("D")
                for(i in 0 until cY - y) {
                    cmd.execute("M")
                }
            }
        }
        f.field[x][y] = "i"
    }

    fun move(){
        val pos = this.getPos()
        val x: Int = pos.substring(1, 2).toInt()
        val y: Int = pos.substring(4, 5).toInt()

        when(this.getFacingSide()) {
            CardinalHelper.NORTH -> {
                f.field[x - 1][y] = f.field[x][y]
                f.field[x][y] = " "
                this.setPos(x - 1, y, CardinalHelper.NORTH)
            }

            CardinalHelper.SOUTH -> {
                f.field[x + 1][y] = f.field[x][y]
                f.field[x][y] = " "
                this.setPos(x + 1, y, CardinalHelper.SOUTH)
            }

            CardinalHelper.EAST -> {
                f.field[x][y + 1] = f.field[x][y]
                f.field[x][y] = " "
                this.setPos(x, y + 1, CardinalHelper.EAST)
            }

            CardinalHelper.WEST -> {
                f.field[x][y - 1] = f.field[x][y]
                f.field[x][y] = " "
                this.setPos(x, y - 1, CardinalHelper.WEST)
            }
        }
    }

    fun rotateTo(d: String){
        val pos = this.getPos()
        val x: Int = pos.substring(1, 2).toInt()
        val y: Int = pos.substring(4, 5).toInt()

        if(d == "right"){
            when(currentFacingSide) {
                "^" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.EAST) }
                "v" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.WEST) }
                ">" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.SOUTH) }
                "<" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.NORTH) }
            }
        } else if(d == "left") {
            when(currentFacingSide) {
                "^" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.WEST) }
                "v" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.EAST) }
                ">" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.NORTH) }
                "<" -> { f.field[x][y] = this.setFacingSide(CardinalHelper.SOUTH) }
            }
        }
    }

    fun setPos(posX: Int, posY: Int, helper: CardinalHelper){
        if(posX > f.rows || posY > f.columns){
            println("Posição inválida!!")
        } else {
            f.field[posX][posY] = this.setFacingSide(helper)
            this.position = String.format("(%d, %d)", posX, posY)
        }
    }

    fun getPos(): String{
        for((i, r) in f.field.withIndex()){
            val j = 0
            for(c in r){
                if(f.field[i][j] == this.currentFacingSide){
                    position = String.format("(%d, %d)", i, j)
                }
            }
        }
        return position
    }

    private fun setFacingSide(pos: CardinalHelper): String {
        return when (pos) {
            CardinalHelper.NORTH -> { this.currentFacingSide = "^"; currentFacingSide }
            CardinalHelper.SOUTH -> { this.currentFacingSide = "v"; currentFacingSide }
            CardinalHelper.EAST -> { this.currentFacingSide = ">"; currentFacingSide }
            CardinalHelper.WEST -> { this.currentFacingSide = "<"; currentFacingSide }
        }
    }

    private fun getFacingSide(): CardinalHelper{
        return when(currentFacingSide) {
            "^" -> { CardinalHelper.NORTH }
            "v" -> { CardinalHelper.SOUTH}
            ">" -> { CardinalHelper.EAST}
            "<" -> { CardinalHelper.WEST}
            else -> { CardinalHelper.NORTH}
        }
    }
}