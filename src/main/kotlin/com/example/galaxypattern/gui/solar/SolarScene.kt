package com.example.galaxypattern.gui.solar

import com.example.galaxypattern.nav.NavController
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class SolarScene : VBox() {
    private val navController = NavController.getInstance()

    private val scene = this
    private var label: Label = Label("This is the Second Scene")
    private var button: Button = Button("Switch scene")

    init {
        scene.children.addAll(label, button)
        start()
    }

    private fun start() {
        button.setOnAction { navController.navigateTo("StartScene") }
    }
}