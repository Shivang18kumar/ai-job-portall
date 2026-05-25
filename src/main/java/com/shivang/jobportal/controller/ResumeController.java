package com.shivang.jobportal.controller;

import com.shivang.jobportal.dto.ResumeScoreResponse;
import com.shivang.jobportal.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PreAuthorize("hasRole('CANDIDATE')")
    @PostMapping("/score")
    public ResumeScoreResponse scoreResume(
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        return resumeService.scoreResume(file);
    }
}