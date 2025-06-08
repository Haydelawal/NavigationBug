package com.hayde117.navigationbug.navigation

import com.hayde117.navigationbug.data.Person
import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    data object ScreenA: Screens()

    @Serializable
    data class ScreenB(val person: Person): Screens()

    @Serializable
    data object ScreenC: Screens()
}
