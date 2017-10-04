package com.util;

import com.entity.BaseEntity;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import java.util.Date;

public class EntityUtil {

    @PrePersist
    public void prePersist(BaseEntity entity){
        entity.setCreateDate(new Date());
        entity.setModifyDate(new Date());
    }

    @PostUpdate
    public void postPresist(BaseEntity entity){
        entity.setModifyDate(new Date());
    }
}
