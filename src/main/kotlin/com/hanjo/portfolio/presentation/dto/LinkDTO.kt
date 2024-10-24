package com.hanjo.portfolio.presentation.dto

import com.hanjo.portfolio.domain.entity.Link

data class LinkDTO(
    val name: String,
    val content: String
) {
    constructor(link: Link) : this(
        name = link.name.lowercase(),
        content = link.content
    )
}