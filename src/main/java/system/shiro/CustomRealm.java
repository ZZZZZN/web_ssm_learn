package system.shiro;

import com.ssm.service.Loginservice;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import util.Common;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
public class CustomRealm extends AuthorizingRealm {


    @Resource
    private Loginservice loginservice;
    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }


    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //token是用户输入的
        //第一步:丛token中取出身份信息
        String userCode= (String) token.getPrincipal();

        //第二步:根据用户输入的userCode丛数据库查询
        Map userinfo=loginservice.selectUserByUser_name(userCode);
        //模拟从数据库查询到的密码
        String password= Common.isblank(userinfo.get("password"));


        //如果查不到返回null，

        //如果查询到，返回认证信息AuthenticationInfo

        SimpleAuthenticationInfo simpleAuthenticationInfo=new
                SimpleAuthenticationInfo(userCode,password,this.getName());


        return simpleAuthenticationInfo;
    }

    //用于授权，该功能在下篇文章中进行讲解
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
