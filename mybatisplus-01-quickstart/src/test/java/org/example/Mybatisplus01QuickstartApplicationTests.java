package org.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.dao.UserDao;
import org.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    /**
     * 新增
     */
    @Test
    void testSave(){
        User user = new User();
        user.setName("rookie");
        user.setPassword("111");
        user.setAge(19);
        user.setTel("17411117777");
        userDao.insert(user);
    }

    /**
     * 删除 id加上L表名为long
     */
    @Test
    void testDelete(){
        userDao.deleteById(1612802890081497089L);
    }

    /**
     * 修改
     */
    @Test
    void testUpdate(){
        User user = new User();
        user.setName("tom666");
        user.setId(1L);
        userDao.updateById(user);
    }

    /**
     * 按ID查询
     */
    @Test
    void testGetById(){
        User user = userDao.selectById(2L);
        System.out.println(user);
    }

    /**
     * 查询全部
     */
    @Test
    void testGetAll() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    /**
     * 分页查询 Page(pageIndex, sizeOfPage)
     */
    @Test
    void testGetByPage() {
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值： " +  page.getCurrent());
        System.out.println("每页显示数： " +  page.getSize());
        System.out.println("总页数： " +  page.getPages());
        System.out.println("总条数： " +  page.getTotal());
        System.out.println("数据： " +  page.getRecords());
    }

}
