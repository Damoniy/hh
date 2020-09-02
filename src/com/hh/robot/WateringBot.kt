package com.hh.robot

import com.hh.garden.Field
import com.hh.main.Commands
import com.hh.physics.CardinalHelper

class WateringBot(f: Field): Machine(f) {

    var irgH = arrayListOf<String>()

    fun irrigate(){
        val pos = this.getPos()
        irgH.add(pos)
    }

    fun printHistory(){
        for(p in 0 until irgH.size) {
            var pos = irgH[p]

            val x: Int = pos.substring(1, 2).toInt()
            val y: Int = pos.substring(4, 5).toInt()

            f.field[x][y] = String.format("%d", p)
        }
    }
}