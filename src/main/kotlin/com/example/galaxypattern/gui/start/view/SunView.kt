package com.example.galaxypattern.gui.start.view

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class SunView() : Canvas() {

    private val gc: GraphicsContext = this.graphicsContext2D
    private val widthView = 60.0
    private val heightView = 60.0

    init {
        this.width = widthView
        this.height = heightView
    }
    fun draw() {
        gc.clearRect(0.0, 0.0, width, height)
        gc.fill = Color.YELLOW
        gc.fillOval(0.0, 0.0, width, height)
    }
}