package com.example.galaxypattern.gui.start.view

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class SunView(private val color: Color, private val x: Double, private val y: Double, private val radiusCorrection: Double) : Canvas() {

    private val gc: GraphicsContext = this.graphicsContext2D

    private val radius = 1392520.0 / radiusCorrection

    init {
        this.width = radius
        this.height = radius

        this.translateX = x
        this.translateY = y
    }

    fun draw() {
        gc.clearRect(0.0, 0.0, radius, radius)
        gc.fill = color
        gc.fillOval(0.0, 0.0, radius, radius)
    }
}