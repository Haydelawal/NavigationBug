package com.hayde117.navigationbug.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.hayde117.navigationbug.data.Person
import com.hayde117.navigationbug.screens.ScreenA
import com.hayde117.navigationbug.screens.ScreenB
import com.hayde117.navigationbug.screens.ScreenC
import com.hayde117.navigationbug.utils.CustomNavType
import kotlin.reflect.typeOf

@Composable
fun MainNavigation(modifier: Modifier, navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.ScreenA) {

        composable<Screens.ScreenA> {
            ScreenA(
                modifier = modifier,
                onClick = {
                    val fakePerson = Person(
                        id = 99,
                        firstName = "John",
                        middleName = "Danger",
                        lastName = "Doe",
                        gender = "Male",
                        age = "30"
                    )
                    navController.navigate(Screens.ScreenB(fakePerson))
                })
        }
        composable<Screens.ScreenB>(
            typeMap = mapOf(
                typeOf<Person>() to CustomNavType<Person>(
                    Person::class,
                    Person.serializer()
                )
            )
        ) {
            val args = it.toRoute<Screens.ScreenB>()

            ScreenB(
                modifier = modifier,
                onClick = { navController.navigate(Screens.ScreenC) },
                person = args.person
            )
        }
        composable<Screens.ScreenC> {
            ScreenC(
                modifier = modifier
            )
        }
    }
}

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED
