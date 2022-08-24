package com.example.galaxypattern.main.view

import javafx.scene.control.Button
import javafx.scene.control.Slider
import javafx.scene.layout.StackPane

class MainMenuView(widthView: Double, heightView: Double) : StackPane() {

    private val scene = this

    var roundRectBackgroundView = RoundRectBackgroundView(widthView, heightView)
    var button: Button = Button("Start")
    var btnPlayStop: Button = Button("Play/Stop")
    var slider: Slider = Slider(0.0, 25.0, 0.0)

    val left = -widthView / 2
    val right = widthView / 2
    val margin = 20.0

    init {
        this.width = widthView
        this.height = heightView

        button.apply {
            maxWidth = 100.0
            translateX = left + maxWidth / 2 + margin
            style = "-fx-background-color: #99CCFF;"
        }
        btnPlayStop.apply {
            maxWidth = 100.0
            style = "-fx-background-color: #FFFFFF;"
        }
        slider.apply {
            maxWidth = 150.0
            translateX = right - maxWidth / 2 - margin
            majorTickUnit = 5.0;
            blockIncrement = 2.5;
            isShowTickLabels = true;
            isShowTickMarks = true;
            isSnapToTicks = true
        }

        scene.children.addAll(roundRectBackgroundView, button, btnPlayStop, slider)
    }

    fun update() {
        roundRectBackgroundView.draw()
    }
}