package com.example.galaxypattern.solar

import com.example.galaxypattern.nav.NavController
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class SolarScene : VBox() {
    val navController = NavController.getInstance()

    val scene = this
    var label: Label = Label("This is the Second Scene")
    var button: Button = Button("Switch scene")

    init {
        scene.children.addAll(label, button)
        start()
    }

    private fun start() {
        button.setOnAction { navController.navigateTo("StartScene") }
    }
}