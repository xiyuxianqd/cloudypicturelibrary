package com.xiyuxian.picturecloudy.interfaces.assembler;

import com.xiyuxian.picturecloudy.domain.space.entity.SpaceUser;
import com.xiyuxian.picturecloudy.interfaces.dto.spaceuser.SpaceUserAddRequest;
import com.xiyuxian.picturecloudy.interfaces.dto.spaceuser.SpaceUserEditRequest;
import org.springframework.beans.BeanUtils;

public class SpaceUserAssembler {

    public static SpaceUser toSpaceUserEntity(SpaceUserAddRequest request) {
        SpaceUser spaceUser = new SpaceUser();
        BeanUtils.copyProperties(request, spaceUser);
        return spaceUser;
    }

    public static SpaceUser toSpaceUserEntity(SpaceUserEditRequest request) {
        SpaceUser spaceUser = new SpaceUser();
        BeanUtils.copyProperties(request, spaceUser);
        return spaceUser;
    }
}
