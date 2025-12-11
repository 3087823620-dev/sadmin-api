package cn.fzw.demo.entity;

import cn.fzw.demo.entity.proxy.UsersEntityProxy;
import com.easy.query.core.annotation.*;
import com.easy.query.core.basic.extension.logicdel.LogicDeleteStrategyEnum;
import com.easy.query.core.enums.RelationTypeEnum;
import com.easy.query.core.proxy.ProxyEntityAvailable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 用户表 实体类。
 *
 * @author easy-query-plugin automatic generation
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "users")
@EntityProxy
public class UsersEntity implements ProxyEntityAvailable<UsersEntity, UsersEntityProxy> {

    /**
     * 用户ID
     */
    @Column(primaryKey = true, value = "id")
    private Integer id;

    /**
     * 关联部门ID
     */
    private Integer deptId;

    /**
     * 关联角色ID
     */
    private Integer roleId;

    /**
     * 账户账号
     */
    private String username;

    /**
     * 账户密码
     */
    @ONodeAttr(ignore = true)
    private String password;

    /**
     * 账户盐值
     */
    @ONodeAttr(ignore = true)
    private String salts;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 用户备注
     */
    private String remarks;

    /**
     * 账户状态，1正常/0禁用
     */
    private Integer status;

    /**
     * 删除状态，0未删除
     */
    @LogicDelete(strategy = LogicDeleteStrategyEnum.DELETE_LONG_TIMESTAMP)
    private Long deleted;

    @Navigate(value = RelationTypeEnum.ManyToOne)
    private DeptEntity dept;

    @Navigate(value = RelationTypeEnum.ManyToOne)
    private RoleEntity role;
}
