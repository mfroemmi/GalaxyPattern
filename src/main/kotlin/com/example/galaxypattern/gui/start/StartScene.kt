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
        scene.children.addAll(viewModel.backgroundView, viewModel.sunView, viewModel.label, viewModel.button)
        start()
        timer.start()
    }

    private fun start() {
        viewModel.button.setOnAction {
            timer.stop()
            navController.navigateTo("SolarScene")
        }

        viewModel.planets[0]
    }

    private fun update() {
        viewModel.backgroundView.draw()
        viewModel.sunView.draw()
    }
}