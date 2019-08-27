package com.kaysen.shop.web.system.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysMenuVo extends SysMenu {

    private List<SysMenuVo> child;



    public List<SysMenuVo> getChild() {
        return child;
    }

    public void setChild(List<SysMenuVo> child) {
        this.child = child;
    }
}