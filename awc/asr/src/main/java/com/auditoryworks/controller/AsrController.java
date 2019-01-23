package com.auditoryworks.controller;

import com.auditoryworks.domain.Asr;
import com.auditoryworks.domain.Message;
import com.auditoryworks.service.AsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AsrController {
    @Autowired
    AsrService asrService;

    @GetMapping("/ping")
    @PreAuthorize("hasAnyAuthority('query')")
    public String ping() {
        return "pong";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('query')")
    public String principal() {
        return asrService.user();
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('query')")
    public Message save(Asr asr) {
        return asrService.saveAsr(asr);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyAuthority('query')")
    public Message delete(Long id) {
        return asrService.deleteAsrById(id);
    }

    @GetMapping("/asr")
    @PreAuthorize("hasAnyAuthority('query')")
    public Page<Asr> findPage(int pagenum, int pagesize) {
        return asrService.findPage(pagenum,pagesize);
    }
}