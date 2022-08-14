package com.example.galaxypattern.main

import com.example.galaxypattern.nav.NavController
import com.example.galaxypattern.gui.solar.SolarScene
import com.example.galaxypattern.gui.start.StartScene
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class MainApplication : Application() {
    override fun start(stage: Stage) {
        val navController = NavController.getInstance()
        val viewModel = MainViewModel.getInstance()

        val startRoot = StartScene()
        val solarRoot = SolarScene()
        val startScene = Scene(startRoot, viewModel.width, viewModel.height)
        val solarScene = Scene(solarRoot, viewModel.width, viewModel.height)

        navController.addStage(stage)
        navController.addScene(Pair(startScene, "StartScene"))
        navController.addScene(Pair(solarScene, "SolarScene"))

        stage.title = "Galaxy Pattern"
        stage.scene = startScene
        stage.show()
    }
}

fun main() {
    Application.launch(MainApplication::class.java)
}