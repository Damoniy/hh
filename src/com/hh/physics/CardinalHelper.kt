package com.hh.physics

enum class CardinalHelper {
    NORTH("N"), SOUTH("S"), EAST("L"), WEST("O");

    var pos = "";

    constructor(dir: String){
        this.pos = dir;
    }

    fun getValue(): String {
        return pos;
    }
}