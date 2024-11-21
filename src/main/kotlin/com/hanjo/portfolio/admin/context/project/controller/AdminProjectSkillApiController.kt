package com.hanjo.portfolio.admin.context.project.controller

import com.hanjo.portfolio.admin.context.project.form.ProjectForm
import com.hanjo.portfolio.admin.context.project.form.ProjectSkillForm
import com.hanjo.portfolio.admin.context.project.service.AdminProjectService
import com.hanjo.portfolio.admin.context.project.service.AdminProjectSkillService
import com.hanjo.portfolio.admin.data.ApiResponse
import com.hanjo.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/api/projects/skills")
class AdminProjectSkillApiController(
    private val adminProjectSkillService: AdminProjectSkillService
) {

    @PostMapping
    fun postProject(@RequestBody @Validated form: ProjectSkillForm): ResponseEntity<Any> {
        adminProjectSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @DeleteMapping("/{id}")
    fun deleteProjectSkill(@PathVariable id:Long): ResponseEntity<Any> {
        adminProjectSkillService.deletes(id)

        return ApiResponse.successDelete()
    }
}