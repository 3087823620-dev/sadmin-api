package cn.fzw.demo.filter;


import cn.fzw.demo.utils.ResponseResult;
import cn.hutool.core.exceptions.ValidateException;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.exception.StatusException;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;

/**
   * 统一异常处理
   */
  @Component
public class ExceptionFilter implements Filter {

    @Override
    public void doFilter(Context ctx, FilterChain  chain)throws Throwable{
                try{
                    //放行操作
                    chain.doFilter(ctx);
                }catch (ValidateException  e){
                    //ValidateException 请求参数校验异常
                    // 封装返回400状态
                    ctx.render( new ResponseResult(400,e.getMessage(),null));
                }catch (StatusException  e){
                    //StatusException  请求状态异常
                    // 封装返回对应状态
                    ctx.render( new ResponseResult(e.getCode(),e.getMessage(),null));
                }catch (Throwable e){
                    // 封装返回500状态
                    ctx.render( new ResponseResult(500,e.getMessage(),null));
                }
        }

}
