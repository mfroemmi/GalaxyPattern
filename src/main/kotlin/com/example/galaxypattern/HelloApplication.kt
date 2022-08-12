package com.example.galaxypattern

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val root1 = Scene1()
        val root2 = Scene2()
        val scene1 = Scene(root1, 320.0, 240.0)
        val scene2 = Scene(root2, 320.0, 240.0)
        stage.title = "Galaxy Pattern"
        stage.scene = scene1
        stage.show()

        root1.start()
        root2.start()
        root1.button1.setOnAction { stage.scene = scene2 }
        root2.button2.setOnAction { stage.scene = scene1 }
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}