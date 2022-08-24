package com.example.galaxypattern.main.view

import com.example.galaxypattern.model.Planet
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import kotlin.math.cos
import kotlin.math.sin

class PlanetView(private val planet: Planet, private val color: Color) : Canvas() {

    private val gc: GraphicsContext = this.graphicsContext2D

    var phi = 0.0
    private val radius = planet.diameter.toDouble() / 2000.0

    init {
        this.width = radius
        this.height = radius
    }

    fun draw(distanceCorrection: Int, rotationSpeed: Double) {
        if (phi >= 360.0) {
            phi = 0.0
        } else {
            phi += 1 * rotationSpeed / planet.period
            this.translateX = planet.distance * cos(phi) * distanceCorrection
            this.translateY = planet.distance * sin(phi) * distanceCorrection
        }

        gc.clearRect(0.0, 0.0, radius, radius)
        gc.fill = color
        gc.fillOval(0.0, 0.0, radius, radius)
    }
}