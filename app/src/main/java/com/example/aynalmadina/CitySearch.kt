package com.example.aynalmadina

import java.util.Locale

class CitySearch {
    private val root = TrieNode()

    fun insert(city: City) {
        var node = root
        for (char in city.name.toLowerCase(Locale.ROOT)) {
            node = node.children.computeIfAbsent(char) { TrieNode() }
        }
        node.cities.add(city)
    }

    fun search(prefix: String): List<City> {
        var node = root
        for (char in prefix.toLowerCase(Locale.ROOT)) {
            node = node.children[char] ?: return emptyList()
        }
        return node.cities
    }

    private class TrieNode {
        val children: MutableMap<Char, TrieNode> = mutableMapOf()
        val cities: MutableList<City> = mutableListOf()
    }
}