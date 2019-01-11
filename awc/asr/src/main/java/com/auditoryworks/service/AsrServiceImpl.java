package com.auditoryworks.service;

import com.auditoryworks.domain.Asr;
import com.auditoryworks.repository.AsrRepository;
import com.auditoryworks.status.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AsrServiceImpl implements AsrService {
    @Autowired
    AsrRepository asrRepository;

    @Override
    public Message saveAsr(Asr asr) {
        asr.setDeadline(new Date());
        asr.setUser(user());
        asrRepository.save(asr);
        return new Message(true,"保存成功",new Date().getTime());
    }

    @Override
    public Message deleteAsrById(Long id) {
        Asr existing=asrRepository.findById(id);
        if(existing==null){
            return new Message(false,"当前指定的文章不存在",new Date().getTime());
        }else{
            if(!existing.getUser().equals(user())){
                return new Message(false,"不是文章所有者，没有删除文章的权限",new Date().getTime());
            }else{
                asrRepository.delete(existing);
                return new Message(true,"删除成功",new Date().getTime());
            }
        }
    }

    @Override
    public Page<Asr> findPage(int pageNum,int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(pageNum,pageSize,sort);
        return asrRepository.findByUser(user(),pageable);
    }

    @Override
    public String user()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}
