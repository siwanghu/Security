package com.auditoryworks.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Asr{
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Long duration;

    private int  important;

    private Date saveTime;

    private Date updateTime;

    private String deviceId;

    private String sessionId;

    private int ip;

    private int port;

    private Long startTime;

    private Long endTime;

    private String userName;
}