package com.example.galaxypattern.util.planetFactory

import com.example.galaxypattern.model.Planet
import com.example.galaxypattern.util.stringFacadeManager.StringManager
import com.example.galaxypattern.util.stringFacadeManager.StringParam

class NoMoons(private val planet: Planet) : IPlanetParamHelper {
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

    override fun distance(): String {
        return "${planet.distance} AE"
    }

    override fun period(): String {
        return "${planet.period} ${StringManager().getString(StringParam.Planet_Info_Period)}"
    }

    override fun rotation(): String {
        return "${planet.rotation} ${StringManager().getString(StringParam.Planet_Info_Rotation)}"
    }

    override fun atmosphere(): String {
        return planet.atmosphere
    }

    override fun moons(): String {
        return StringManager().getString(StringParam.Planet_Info_Moons)
    }

    override fun inclination(): String {
        return "${planet.inclination} °"
    }
}