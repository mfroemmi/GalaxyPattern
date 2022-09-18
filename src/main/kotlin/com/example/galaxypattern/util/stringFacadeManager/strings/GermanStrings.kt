package com.example.galaxypattern.util.stringFacadeManager.strings

import com.example.galaxypattern.util.stringFacadeManager.IStringManager
import com.example.galaxypattern.util.stringFacadeManager.StringParam

class GermanStrings : IStringManager {
    override fun getString(string: StringParam): String {
        return when (string) {
            StringParam.Planet_Info_Period -> "Tage"
            StringParam.Planet_Info_Rotation -> "Tage"
            StringParam.Planet_Info_Moons -> "Keine Monde"
            StringParam.Planet_Info_Atmosphere -> "Keine Atmosphäre"
        }
    }
}