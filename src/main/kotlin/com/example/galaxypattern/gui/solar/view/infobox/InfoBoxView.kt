package com.example.galaxypattern.gui.solar.view.infobox

import com.example.galaxypattern.main.MainViewModel
import com.example.galaxypattern.model.Planet
import javafx.scene.control.Label
import javafx.scene.layout.*

class InfoBoxView(planet: Planet) : VBox() {

    private val viewModel = MainViewModel.getInstance()

    private val scene = this

    private val widthView = 500.0
    private val heightView = 500.0

    private val headHeight = 25.0
    private val bodyHeight = 475.0

    var titel: Label = Label(planet.name)
    val head = HeadInfoView(widthView, headHeight)
    val body = BodyInfoView(widthView, bodyHeight)

    val headStackPane = StackPane()

    var remove = false

    init {
        this.width = widthView
        this.height = heightView

        titel.apply {
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 16; "
        }
        head.apply {
            setMaxSize(widthView, headHeight)
        }
        body.apply {
            setMaxSize(widthView, bodyHeight)
        }

        headStackPane.setOnMouseClicked {
            remove = true
        }

        headStackPane.children.addAll(head, titel)
        scene.children.addAll(headStackPane, body)
    }

    fun update() {
        head.draw()
        body.draw()
    }
}