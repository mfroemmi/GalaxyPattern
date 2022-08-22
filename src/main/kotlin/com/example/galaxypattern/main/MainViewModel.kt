package com.example.galaxypattern.main

import com.example.galaxypattern.model.Planet
import com.example.galaxypattern.util.planetFactory.*

class MainViewModel {

    /**
     * Singleton pattern
     */
    companion object {
        @Volatile
        private lateinit var instance: MainViewModel

        fun getInstance(): MainViewModel {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = MainViewModel()
                }
                return instance
            }
        }
    }

    val width = 1280.0
    val height = 768.0

    var planets: MutableList<Planet> = mutableListOf()

    init {
        createPlanets()

        for (planet in planets) {
            println(planetParams(planet).name())
            println(planetParams(planet).diameter())
            println(planetParams(planet).mass())
            println(planetParams(planet).density())
            println(planetParams(planet).distance())
            println(planetParams(planet).period())
            println(planetParams(planet).rotation())
            println(planetParams(planet).atmosphere())
            println(planetParams(planet).moons())
            println(planetParams(planet).inclination())
            println()
        }
    }

    private fun createPlanets() {
        planets.add(Planet(PlanetType.MERKUR,"Merkur", 4878.0f, 0.055f, 5.43f, 0.39f, 87.97f, 58.6f, inclination = 7.0f))
        planets.add(Planet(PlanetType.VENUS,"Venus", 12104.0f, 0.8f, 5.25f, 0.72f, 224.7f, 243.0f, atmosphere = "CO2 (95%)", inclination = 3.4f))
        planets.add(Planet(PlanetType.ERDE,"Erde", 12756.0f, 1.0f, 5.52f, 1.0f, 365.26f, 0.993f,"N2 (78%), O2 (21%)", 1, 0.0f))
        planets.add(Planet(PlanetType.MARS,"Mars", 6794.0f, 0.107f, 3.93f, 1.52f, 687.0f, 1.026f,"CO2 (95%), N2 (3%)", 2, 1.9f))
        planets.add(Planet(PlanetType.JUPITER,"Jupiter", 142796.0f, 317.9f, 1.33f, 5.2f, 365.26f * 11.87f, 0.41f, moons = 63, inclination = 1.3f))
        planets.add(Planet(PlanetType.SATURN,"Saturn", 120000.0f, 95.15f, 0.69f, 9.58f, 365.26f * 29.46f, 0.45f, moons = 56, inclination = 2.5f))
        planets.add(Planet(PlanetType.URANUS,"Uranus", 51118.0f, 14.54f, 1.27f, 19.28f, 365.26f * 84.67f, 0.72f, moons = 27, inclination = 0.7f))
        planets.add(Planet(PlanetType.NEPTUN,"Neptun", 49424.0f, 17.15f, 1.67f, 30.14f, 365.26f * 165.49f, 0.67f, moons = 13, inclination = 1.8f))
    }

    /**
     * Factory pattern
     *
     * @see IPlanetParamHelper
     * @see PlanetType
     * @see AllParams
     * @see NoAtmosphere
     * @see NoMoons
     * @see NoMoonsAtmosphere
     *
     * @return IPlanetParamHelper
     */
    fun planetParams(planet: Planet): IPlanetParamHelper {
        return when (planet.type) {
            PlanetType.ERDE, PlanetType.MARS -> AllParams(planet)
            PlanetType.MERKUR -> NoMoonsAtmosphere(planet)
            PlanetType.VENUS -> NoMoons(planet)
            PlanetType.JUPITER, PlanetType.SATURN, PlanetType.URANUS, PlanetType.NEPTUN -> NoAtmosphere(planet)
        }
    }
}