package com.hh.garden

class Field(rows: Int, columns: Int) {
    var field: Array<Array<String?>> = Array(rows) { Array<String?>(columns) {" "} }
    var rows = rows
    var columns = columns

}