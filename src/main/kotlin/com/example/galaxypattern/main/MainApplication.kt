package com.example.galaxypattern.main

import com.example.galaxypattern.nav.NavController
import com.example.galaxypattern.solar.SolarScene
import com.example.galaxypattern.start.StartScene
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class MainApplication : Application() {
    override fun start(stage: Stage) {
        val navController = NavController.getInstance()
        navController.addStage(stage)

        val startRoot = StartScene()
        val solarRoot = SolarScene()
        val startScene = Scene(startRoot, 320.0, 240.0)
        val solarScene = Scene(solarRoot, 320.0, 240.0)

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