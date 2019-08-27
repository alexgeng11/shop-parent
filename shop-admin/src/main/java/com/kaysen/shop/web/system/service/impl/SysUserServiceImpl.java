package com.kaysen.shop.web.system.service.impl;

import com.kaysen.shop.web.system.bean.*;
import com.kaysen.shop.web.system.dao.*;
import com.kaysen.shop.web.system.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    public SysUserServiceImpl() {
        System.out.println("############################################");
    }

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public List<SysUser> listAllUser() {
        return sysUserMapper.selectAll();
    }

    @Override
    public SysUser findByUserName(String userName) {
        SysUser sysUser=new SysUser();
        sysUser.setUserName(userName);
        return sysUserMapper.selectOne(sysUser);

    }

    @Override
    public List<SysMenuVo> searchSysFun(SysUser sysUser) {
        SysUserRole sysUserRole=new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        sysUserRole.setIsDele("0");
        List<SysUserRole> select = sysUserRoleMapper.select(sysUserRole);
        for (SysUserRole userRole: select) {
            SysRoleMenu roleMenu=new SysRoleMenu();
            roleMenu.setRoleId(userRole.getId());
            roleMenu.setIsDele("0");


        }
        return null;
    }

    @Override
    @Transactional
    public void addUser(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
        throw new NullPointerException();
    }
}


