package com.hanjo.portfolio.admin.context.project.service

import com.hanjo.portfolio.admin.data.TableDTO
import com.hanjo.portfolio.admin.exception.AdminBadRequestException
import com.hanjo.portfolio.domain.entity.Project
import com.hanjo.portfolio.domain.entity.ProjectDetail
import com.hanjo.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(
    private val ProjectRepository: ProjectRepository
) {

    fun getProjectTable(): TableDTO {
        val classInfo = Project::class
        val entities = ProjectRepository.findAll()

        return TableDTO.from(classInfo, entities, "details", "skills")
    }

    fun getProjectDetailTable(id:Long?): TableDTO {
        val classInfo = ProjectDetail::class
        val entities = if(id != null) ProjectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}의 해당하는 데이터를 찾을 수 없습니다.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }
}