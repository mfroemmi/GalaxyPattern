package com.example.galaxypattern

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class Scene2 : VBox() {
    val scene = this
    var label2: Label = Label("This is the Second Scene")
    var button2: Button = Button("Switch scene")

    fun start() {
        scene.children.addAll(label2, button2)
    }
}