package io.github.ilyapavlovskii.kmm.analytics

interface AnalyticsTracker {
    fun trackEvent(event: AnalyticsEvent)
}