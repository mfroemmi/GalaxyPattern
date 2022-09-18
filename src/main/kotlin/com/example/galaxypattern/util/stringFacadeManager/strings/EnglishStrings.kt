package com.example.galaxypattern.util.stringFacadeManager.strings

import com.example.galaxypattern.util.stringFacadeManager.IStringManager
import com.example.galaxypattern.util.stringFacadeManager.StringParam

class EnglishStrings : IStringManager {
    override fun getString(string: StringParam): String {
        return when (string) {
            StringParam.Planet_Info_Period -> "days"
            StringParam.Planet_Info_Rotation -> "days"
            StringParam.Planet_Info_Moons -> "No moons"
            StringParam.Planet_Info_Atmosphere -> "No atmosphere"
        }
    }
}