package io.github.ilyapavlovskii.kmm.koin

import org.koin.core.module.Module

interface Component {
    val modules: List<Module>
}
