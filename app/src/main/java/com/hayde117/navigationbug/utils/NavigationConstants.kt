package com.hayde117.navigationbug.utils

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.hayde117.navigationbug.data.Person
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

/** This is the buggy version, i do not know why it is buggy exactly but it seems like
 * it might be because come used routes before and thats similar to urls i guess
 * so maybe the way bundle is being handled on devices causes the issues.
 * i don't know, it could be anything behind the scenes */
class CustomNavType<T : Parcelable>(
    private val clazz: KClass<T>,
    private val serializer: KSerializer<T>
) : NavType<T>(false) {
    override fun get(bundle: Bundle, key: String): T? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, clazz.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): T {
        return Json.decodeFromString(serializer, value)
    }

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putParcelable(key, value)
    }

    override fun serializeAsValue(value: T): String {
        return Json.encodeToString(serializer, value)
    }
}


/** use this insteaddddd!!!!! */
object NavigationConstants {
    val PersonType = object : NavType<Person>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Person? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Person {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Person): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Person) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}