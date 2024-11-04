package com.hanjo.portfolio.admin.context.link.service

import com.hanjo.portfolio.admin.data.TableDTO
import com.hanjo.portfolio.domain.entity.Achievement
import com.hanjo.portfolio.domain.entity.Introduction
import com.hanjo.portfolio.domain.entity.Link
import com.hanjo.portfolio.domain.repository.IntroductionRepository
import com.hanjo.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}