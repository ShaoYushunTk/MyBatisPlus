package org.example.User.service.impl;

import org.example.User.domain.User;
import org.example.User.dao.UserMapper;
import org.example.User.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yushun Shao
 * @since 2023-01-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
