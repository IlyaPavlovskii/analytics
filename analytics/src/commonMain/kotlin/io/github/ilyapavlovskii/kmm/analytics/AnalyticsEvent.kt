package io.github.ilyapavlovskii.kmm.analytics

/**
 * Common analytics event
 * */
sealed class AnalyticsEvent {
    abstract val action: String

    /**
     * Simple action without any payload
     */
    data class Simple(override val action: String) : AnalyticsEvent()

    /**
     * Action with generic payload (key/value)
     */
    data class WithPayload(
        override val action: String,
        val payload: Map<String, Any>,
    ) : AnalyticsEvent()
}
