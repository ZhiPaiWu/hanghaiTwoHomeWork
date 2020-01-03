package cn.crud.dao;

import cn.crud.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
/**
 * 简单的dao层只需要继承JpaRepository接口，即可，
 * 两个参数，分别表示 —— 实体类型、主键类型
 * 复杂sql语句再自己增加接口
 * @author linhongcun
 *
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<UserInfo> {
}
