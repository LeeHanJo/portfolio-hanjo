package com.hanjo.portfolio.admin.context.skill.controller

import com.hanjo.portfolio.admin.context.skill.service.AdminSkillService
import com.hanjo.portfolio.admin.data.FormElementDTO
import com.hanjo.portfolio.admin.data.SelectFormElementDTO
import com.hanjo.portfolio.admin.data.TextFormElementDTO
import com.hanjo.portfolio.domain.constant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/skill")
class AdminSkillViewController(
    private val adminSkillService: AdminSkillService
) {

    @GetMapping
    fun skill(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("name", 2),
            SelectFormElementDTO("type", 2, SkillType.values().map { it.name }.toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElements", formElements)

        val table = adminSkillService.getSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any> (
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletabe", false),
            Pair("hasDetails", false),
        )
        model.addAllAttributes(pageAttributes)

        return "/admin/page-table"
    }

}