package com.example.galaxypattern.gui.start.view

import com.example.galaxypattern.main.MainViewModel
import com.example.galaxypattern.main.view.PlanetView
import com.example.galaxypattern.main.view.SunView
import com.example.galaxypattern.util.planetFactory.PlanetType
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color

class SolarSystemView() : StackPane() {

    private val viewModel = MainViewModel.getInstance()

    private val scene = this

    private var solarSystem: MutableList<PlanetView> = mutableListOf()

    val sun = SunView(Color.WHITE, 0.0, 0.0, 60000.0)
    val mercury = PlanetView(viewModel.planets.find { it.type == PlanetType.MERKUR }.let { it!! }, Color.LIGHTGRAY)
    val venus = PlanetView(viewModel.planets.find { it.type == PlanetType.VENUS }.let { it!! }, Color.SLATEGRAY)
    val earth = PlanetView(viewModel.planets.find { it.type == PlanetType.ERDE }.let { it!! }, Color.FLORALWHITE)
    val mars = PlanetView(viewModel.planets.find { it.type == PlanetType.MARS }.let { it!! }, Color.GRAY)
    val jupiter = PlanetView(viewModel.planets.find { it.type == PlanetType.JUPITER }.let { it!! }, Color.WHITE)
    val saturn = PlanetView(viewModel.planets.find { it.type == PlanetType.SATURN }.let { it!! }, Color.LIGHTGRAY)
    val uranus = PlanetView(viewModel.planets.find { it.type == PlanetType.URANUS }.let { it!! }, Color.SLATEGRAY)
    val neptune = PlanetView(viewModel.planets.find { it.type == PlanetType.NEPTUN }.let { it!! }, Color.FLORALWHITE)

    init {
        this.width = viewModel.width
        this.height = viewModel.height

        solarSystem.addAll(mutableListOf(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune))

        scene.children.addAll(sun, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune)
    }

    fun update() {
        sun.draw()
        for ((index, planet) in solarSystem.withIndex()) {
            val distanceCorrection = -4 * index + 40
            planet.draw(distanceCorrection)
        }
    }
}