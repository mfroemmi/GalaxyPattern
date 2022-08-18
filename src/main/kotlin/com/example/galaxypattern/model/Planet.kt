package com.example.galaxypattern.model

import com.example.galaxypattern.util.planetFactory.PlanetType

class Planet(
    val type: PlanetType,
    val name: String,
    val diameter: Float,
    val mass: Float,
    val density: Float,
    val distance: Float,
    val period: Float,
    val rotation: Float,
    val atmosphere: String = "",
    val moons: Int = 0,
    val inclination: Float
) {
}