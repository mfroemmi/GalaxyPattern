package com.example.galaxypattern.gui.start

import com.example.galaxypattern.gui.start.view.BackgroundView
import com.example.galaxypattern.gui.start.view.SunView
import com.example.galaxypattern.model.Planet
import com.example.galaxypattern.util.planetFactory.*
import javafx.scene.control.Button
import javafx.scene.control.Label

class StartViewModel {

    /**
     * Singleton pattern
     */
    companion object {
        @Volatile
        private lateinit var instance: StartViewModel

        fun getInstance(): StartViewModel {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = StartViewModel()
                }
                return instance
            }
        }
    }

    var planets: MutableList<Planet> = mutableListOf()

    var label: Label = Label("Galaxy Pattern")
    var button: Button = Button("Solar System")
    val backgroundView = BackgroundView()
    val sunView = SunView()

    init {
        label.apply {
            translateY = -200.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 48; "
        }
        button.apply {
            translateY = 200.0
            style = "-fx-background-color: #FFFFFF;"
        }

        createPlanets()

        for (planet in planets) {
            println(planetParams(planet).name())
            println(planetParams(planet).diameter())
            println(planetParams(planet).mass())
            println(planetParams(planet).density())
            println(planetParams(planet).atmosphere())
            println(planetParams(planet).moons())
            println()
        }
    }

    private fun createPlanets() {
        planets.add(Planet(Planets.MERKUR,"Merkur", 4878.0f, 0.055f, 5.43f))
        planets.add(Planet(Planets.VENUS,"Venus", 12104.0f, 0.8f, 5.25f, atmosphere = "CO2 (95%)"))
    }

    /**
     * Factory pattern
     *
     * @see IPlanetParamHelper
     * @see Planets
     * @see AllParams
     * @see NoAtmosphere
     * @see NoMoons
     * @see NoMoonsAtmosphere
     *
     * @return IPlanetParamHelper
     */
    fun planetParams(planet: Planet): IPlanetParamHelper {
        return when (planet.type) {
            Planets.ERDE, Planets.MARS -> AllParams(planet)
            Planets.MERKUR -> NoMoonsAtmosphere(planet)
            Planets.VENUS -> NoMoons(planet)
            Planets.JUPITER, Planets.SATURN, Planets.URANUS, Planets.NEPTUN -> NoAtmosphere(planet)
        }
    }
}