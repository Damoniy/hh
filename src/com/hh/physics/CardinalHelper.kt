package com.hh.physics

enum class CardinalHelper {
    NORTH(0), SOUTH(1), EAST(2), WEST(3);

    var pos = 0;

    constructor(dir: Int){
        this.pos = dir;
    }

    fun getValue(): Int {
        return pos;
    }
}