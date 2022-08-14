package com.example.galaxypattern.gui.start.view

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class BackgroundView() : Canvas() {

    private val gc: GraphicsContext = this.graphicsContext2D
    private val widthView = 1024.0
    private val heightView = 768.0

    init {
        this.width = widthView
        this.height = heightView
    }
    fun draw() {
        gc.clearRect(0.0, 0.0, width, height)
        gc.fill = Color.BLACK
        gc.fillRect(0.0, 0.0, width, height)
    }
}