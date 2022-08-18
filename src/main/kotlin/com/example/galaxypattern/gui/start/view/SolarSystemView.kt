package com.example.galaxypattern.gui.start.view

import com.example.galaxypattern.main.MainViewModel
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import kotlin.math.cos
import kotlin.math.sin

class SolarSystemView() : StackPane() {

    private val viewModel = MainViewModel.getInstance()

    private val scene = this

    val sun = PlanetView(60.0, Color.YELLOW)
    val earth = PlanetView(20.0, Color.BLUE)

    var phi = 0.0

    var xCurve = 150 * cos(phi)
    var yCurve = 150 * sin(phi)

    init {
        this.width = viewModel.width
        this.height = viewModel.height

        scene.children.addAll(sun, earth)
    }

    fun update() {
        if (phi >= 360.0) {
            phi = 0.0
        } else {
            phi += 0.005
            xCurve = 150 * cos(phi)
            yCurve = 150 * sin(phi)
        }

        sun.draw(0.0, 0.0)
        earth.draw(xCurve, yCurve)
    }
}