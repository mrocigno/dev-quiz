package br.com.devquiz.commons.di

import org.koin.core.module.Module

object Initializer {

    val modules = mutableListOf<Module>()

    fun add(modules: List<Module>) {
        this.modules.addAll(modules)
    }
}