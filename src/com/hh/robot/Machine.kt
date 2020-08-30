package com.hh.robot

import com.hh.physics.CardinalHelper

open class Machine {

    fun move(){

    }

    fun rotateTo(){

    }

    fun getFacingPos(pos: CardinalHelper): String {
        when (pos) {
            CardinalHelper.NORTH -> {
                return "^"
            }

            CardinalHelper.SOUTH -> {
                return "v"
            }

            CardinalHelper.EAST -> {
                return ">"
            }

            CardinalHelper.WEST -> {
                return "<"
            }
            else -> {
                return "▲"
            }
        }
    }
}