package com.example.galaxypattern.gui.solar.view.infobox

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class BodyInfoView(widthView: Double, heightView: Double) : Canvas() {

    private val gc: GraphicsContext = this.graphicsContext2D

    init {
        this.width = widthView
        this.height = heightView
    }
    fun draw() {
        gc.clearRect(0.0, 0.0, width, height)
        gc.fill = Color.rgb(50,50,50,0.6)
        gc.fillRoundRect(0.0, 0.0, width, height, 0.0, 0.0)
    }
}