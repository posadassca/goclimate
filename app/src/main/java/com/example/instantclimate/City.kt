package com.example.instantclimate

/*
    class created by Sebastian Posadas
 */
class City(name: String, weather: ArrayList<Weather>, main: Main) {

    var name = ""
    var weather: ArrayList<Weather>? = null
    var main: Main? = null

    init {
        this.name = name
        this.weather = weather
        this.main = main
    }

}