package io.github.ilyapavlovskii.kmm.analytics

import android.os.Bundle

internal fun payloadToBundle(payload: Map<String, Any>): Bundle =
    Bundle().apply {
        payload.onEach { (key, value) ->
            when (value) {
                is Byte -> this.putLong(key, value.toLong())
                is Short -> this.putLong(key, value.toLong())
                is Int -> this.putLong(key, value.toLong())
                is Long -> this.putLong(key, value.toLong())
                is Float -> this.putDouble(key, value.toDouble())
                is Double -> this.putDouble(key, value)
                is String -> this.putString(key, value)
                else -> this.putString(key, value.toString())
            }
        }
    }