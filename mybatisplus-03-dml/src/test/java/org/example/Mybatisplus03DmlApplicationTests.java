package org.example;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Mybatisplus03DmlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave() {
        User user = new User();
//        user.setId(667L);
        user.setName("rookie1111");
        user.setPassword("111222");
        user.setAge(22);
        user.setTel("17411117777");
        userDao.insert(user);
    }

    @Test
    void testDelete(){
        /*List<Long> list = new ArrayList<>();
        list.add(1613106947111227393L);
        list.add(1613108404308840449L);
        userDao.deleteBatchIds(list);*/

        userDao.deleteById(667L);
    }

    @Test
    void testUpdate(){
//        User user = new User();
//        user.setId(3L);
//        user.setName("Jock666");
//        //修改时必须提供version 实现乐观锁
//        user.setVersion(1);
//        userDao.updateById(user);

//        User user = userDao.selectById(3L);
//        user.setName("Jock666777");
//        userDao.updateById(user);

        //模拟两个线程同时对数据进行修改
        User user = userDao.selectById(3L);     //version = 3

        User user2 = userDao.selectById(3L);    //version = 3

        user2.setName("Jock8");                 //version = 4
        userDao.updateById(user2);

        user.setName("Jock9");
        userDao.updateById(user);               //version != 3 修改失效
    }

}
