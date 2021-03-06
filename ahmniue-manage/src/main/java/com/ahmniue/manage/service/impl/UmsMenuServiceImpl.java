package com.ahmniue.manage.service.impl;

import com.ahmniue.manage.service.UmsRoleService;
import com.github.pagehelper.PageHelper;
import com.ahmniue.manage.dto.UmsMenuNode;
import com.ahmniue.generator.mapper.UmsMenuMapper;
import com.ahmniue.generator.model.*;
import com.ahmniue.manage.service.UmsMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台菜单管理Service实现类
 */
@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired
    private UmsMenuMapper menuMapper;
    @Autowired
    private UmsRoleService roleService;

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        umsMenu.setHasChildren(0);
        updateLevel(umsMenu);
//        updateHasChild(umsMenu);
        return menuMapper.insert(umsMenu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenu parentMenu = menuMapper.selectByPrimaryKey(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }
    /**
     * 更新父节点信息
     */
    private void  updateHasChild(UmsMenu umsMenu){
        if (umsMenu.getLevel() != 0) {
            UmsMenu parentMenu = menuMapper.selectByPrimaryKey(umsMenu.getParentId());
            UmsMenuExample example = new UmsMenuExample();
            example.createCriteria().andParentIdEqualTo(parentMenu.getId());
            List<UmsMenu> child = menuMapper.selectByExample(example);
            if (parentMenu != null && child.size() > 0) {
                parentMenu.setHasChildren(1);
            }  else {
                parentMenu.setHasChildren(0);
            }
            menuMapper.updateByPrimaryKeySelective(parentMenu);
        }
    }
    @Override
    public int update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        updateLevel(umsMenu);
//        UmsMenu oldMenu = menuMapper.selectByPrimaryKey(id);
//        if (oldMenu.getParentId() != umsMenu.getParentId()){
//            updateHasChild(umsMenu,1);
//        } else {
//            updateHasChild(umsMenu,-1);
//        }
        return menuMapper.updateByPrimaryKeySelective(umsMenu);
    }

    @Override
    public UmsMenu getItem(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
//        UmsMenu umsMenu = menuMapper.selectByPrimaryKey(id);
//        updateHasChild(umsMenu,-1);
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsMenuExample example = new UmsMenuExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return menuMapper.selectByExample(example);
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = menuMapper.selectByExample(new UmsMenuExample());
        List<UmsMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<UmsMenuNode> treeListRole(Long adminId) {
        List<UmsMenu> menuList = roleService.getMenuList(adminId);
        List<UmsMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return menuMapper.updateByPrimaryKeySelective(umsMenu);
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
