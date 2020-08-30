package com.hh.robot

import com.hh.garden.Field
import com.hh.physics.CardinalHelper

class WateringBot(): Machine() {

    fun irrigate(){

    }

    fun setPos(posX: Int, posY: Int, f: Field){
        while(posX > (f.field.size - 1)){
            println("Posicao invalida!!")
        }

        f.field[posX][posY]
    }
}