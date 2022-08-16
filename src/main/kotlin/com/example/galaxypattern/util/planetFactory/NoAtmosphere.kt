package com.example.galaxypattern.util.planetFactory

import com.example.galaxypattern.model.Planet

class NoAtmosphere(private val planet: Planet) : IPlanetParamHelper {
    override fun name(): String {
        return planet.name
    }

    override fun diameter(): String {
        return "${planet.diameter} km"
    }

    override fun mass(): String {
        return planet.mass.toString()
    }

    override fun density(): String {
        return "${planet.density} g/cm³"
    }

    override fun atmosphere(): String {
        return "No atmosphere"
    }

    override fun moons(): String {
        return planet.moons.toString()
    }
}