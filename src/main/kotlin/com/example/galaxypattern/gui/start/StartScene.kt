package com.example.galaxypattern.gui.start

import com.example.galaxypattern.nav.NavController
import javafx.animation.AnimationTimer
import javafx.scene.layout.StackPane

class StartScene : StackPane() {
    private val navController = NavController.getInstance()
    private val viewModel = StartViewModel.getInstance()

    private val scene = this

    private val timer: AnimationTimer = object : AnimationTimer() {
        override fun handle(now: Long) {
            update()
        }
    }

    init {
        scene.children.addAll(viewModel.backgroundView, viewModel.solarSystemView, viewModel.label, viewModel.button)
        start()
        timer.start()
    }

    private fun start() {
        viewModel.button.setOnAction {
            navController.navigateTo("SolarScene")
        }

        viewModel.solarSystemView.update()
    }

    private fun update() {
        viewModel.backgroundView.draw()
        viewModel.solarSystemView.update()
    }
}