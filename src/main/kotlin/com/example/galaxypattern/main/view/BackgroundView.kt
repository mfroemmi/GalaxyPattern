package com.example.galaxypattern.main.view

import com.example.galaxypattern.main.MainViewModel
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class BackgroundView() : Canvas() {

    private val viewModel = MainViewModel.getInstance()

    private val gc: GraphicsContext = this.graphicsContext2D
    private val widthView = viewModel.width
    private val heightView = viewModel.height

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