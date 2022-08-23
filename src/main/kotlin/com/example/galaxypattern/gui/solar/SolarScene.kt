package com.example.galaxypattern.gui.solar

import com.example.galaxypattern.nav.NavController
import javafx.animation.AnimationTimer
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox

class SolarScene : StackPane() {
    private val navController = NavController.getInstance()
    private val viewModel = SolarViewModel.getInstance()

    private val scene = this

    private val timer: AnimationTimer = object : AnimationTimer() {
        override fun handle(now: Long) {
            update()
        }
    }

    init {
        scene.children.addAll(viewModel.backgroundView, viewModel.solarSystemView, viewModel.label, viewModel.button, viewModel.btnPlayStop, viewModel.slider)
        start()
        timer.start()
    }

    private fun start() {
        viewModel.button.setOnAction {
            navController.navigateTo("StartScene")
        }
        viewModel.btnPlayStop.setOnAction {
            viewModel.isRotate = !viewModel.isRotate
        }
        viewModel.solarSystemView.sun.setOnMouseClicked {
            println("Sun")
        }
        viewModel.solarSystemView.earth.setOnMouseClicked {
            println("Earth")
        }

        viewModel.solarSystemView.update()
    }

    private fun update() {
        viewModel.backgroundView.draw()
        if (viewModel.isRotate) {
            viewModel.solarSystemView.update()
        }
    }
}