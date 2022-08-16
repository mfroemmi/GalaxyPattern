package com.example.galaxypattern.model

import com.example.galaxypattern.util.planetFactory.Planets

class Planet(
    val type: Planets,
    val name: String,
    val diameter: Float,
    val mass: Float,
    val density: Float,
    val atmosphere: String = "",
    val moons: Int = 0
) {
}