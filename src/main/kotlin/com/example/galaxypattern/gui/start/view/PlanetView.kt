package com.example.galaxypattern.gui.start.view

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class PlanetView(private val radius: Double, private val color: Color) : Canvas() {

    private val gc: GraphicsContext = this.graphicsContext2D

    init {
        this.width = radius
        this.height = radius
    }

    fun draw(x: Double, y: Double) {
        this.translateX = x
        this.translateY = y

        gc.clearRect(0.0, 0.0, radius, radius)
        gc.fill = color
        gc.fillOval(0.0, 0.0, radius, radius)
    }
}