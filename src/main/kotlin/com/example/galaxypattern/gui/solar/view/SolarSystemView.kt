package com.example.galaxypattern.gui.solar.view

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

    val sun = SunView(Color.YELLOW, 0.0, 0.0, 60000.0)
    val sunBig = SunView(Color.YELLOW, -viewModel.width / 2, 0.0, 2000.0)
    val mercury = PlanetView(viewModel.planets.find { it.type == PlanetType.MERKUR }.let { it!! }, Color.LIGHTBLUE)
    val venus = PlanetView(viewModel.planets.find { it.type == PlanetType.VENUS }.let { it!! }, Color.GRAY)
    val earth = PlanetView(viewModel.planets.find { it.type == PlanetType.ERDE }.let { it!! }, Color.BLUE)
    val mars = PlanetView(viewModel.planets.find { it.type == PlanetType.MARS }.let { it!! }, Color.DARKRED)
    val jupiter = PlanetView(viewModel.planets.find { it.type == PlanetType.JUPITER }.let { it!! }, Color.ROSYBROWN)
    val saturn = PlanetView(viewModel.planets.find { it.type == PlanetType.SATURN }.let { it!! }, Color.SANDYBROWN)
    val uranus = PlanetView(viewModel.planets.find { it.type == PlanetType.URANUS }.let { it!! }, Color.TURQUOISE)
    val neptune = PlanetView(viewModel.planets.find { it.type == PlanetType.NEPTUN }.let { it!! }, Color.ALICEBLUE)

    init {
        this.width = viewModel.width
        this.height = viewModel.height

        solarSystem.addAll(mutableListOf(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune))

        scene.children.addAll(sun, sunBig, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune)
    }

    fun update() {
        sun.draw()
        sunBig.draw()
        for ((index, planet) in solarSystem.withIndex()) {
            val distanceCorrection = -4 * index + 40
            planet.draw(distanceCorrection)
        }
    }
}