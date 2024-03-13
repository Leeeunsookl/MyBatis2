package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;
    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);        //인터페이스는 스스로 생성하지 못하니까

        List<MenuDTO> menuList = menuMapper. selectAllMenu();
        sqlSession.close();
        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {

        SqlSession sqlSession = getSqlSession();
        /* 필기. sqlSession은 요청 단위로 생성해야 해서 getMapper로 메소드 스코프 매 번 불러와야 한다. */
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menu = menuMapper.selectMenuByCode(code);

        sqlSession.close();
        return menu;

    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertMenu(menu);

        if(result>0){
            sqlSession.commit();
        }else{sqlSession.rollback();}
        sqlSession.close();
        return result>0? true: false;

    }

    public boolean modifyMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);

        if(result>0){
            sqlSession.commit();
        }else{sqlSession.rollback();}
        sqlSession.close();
        return result>0? true: false;

    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(code);

        if(result>0){
            sqlSession.commit();
        }else{sqlSession.rollback();}
        sqlSession.close();
        return result>0? true: false;
    }
}