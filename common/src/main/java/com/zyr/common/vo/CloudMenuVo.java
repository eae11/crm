package com.zyr.common.vo;

import com.zyr.common.entity.CloudMenu;
import lombok.Data;

import java.util.List;
@Data
public class CloudMenuVo extends CloudMenu {
    private List<CloudMenuVo> children;
    private List<CloudMenuVo> menuList;
}
