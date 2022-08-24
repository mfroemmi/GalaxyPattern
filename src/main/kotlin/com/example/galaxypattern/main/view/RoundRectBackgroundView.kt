package com.example.galaxypattern.main.view

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class RoundRectBackgroundView(widthView: Double, heightView: Double) : Canvas() {

    private val gc: GraphicsContext = this.graphicsContext2D

    init {
        this.width = widthView
        this.height = heightView
    }
    fun draw() {
        gc.clearRect(0.0, 0.0, width, height)
        gc.fill = Color.rgb(255,255,255,0.1)
        gc.fillRoundRect(0.0, 0.0, width, height, 10.0, 10.0)
    }
}