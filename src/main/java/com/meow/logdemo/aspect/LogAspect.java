package com.meow.logdemo.aspect;

import com.meow.logdemo.annotation.LogAnn;
import com.meow.logdemo.bean.Log;
import com.meow.logdemo.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Log 切面类
 *
 * *@Pointcut：定义一个切面，即上面所描述的关注的某件事入口
 * *@Before：在做某件事之前做的事
 * *@After：在做某件事之后做的事
 * *@AfterReturning：在做某件事之后，对其返回值做增强处理
 * *@AfterThrowing：在做某件事抛出异常时，处理
 *
 * 1.切入点
 * 2.额外的功能（日志记录）
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    /**
     * 定义切点 @Pointcut()
     * 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.meow.logdemo.annotation.LogAnn))") //切入点表达式  * com.meow.logdemo.service.impl.*.*(..))
    public void myLogPoincut() {
    }

    /**
     * 环绕增强，相当于
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("myLogPoincut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object res = null;
        long time = System.currentTimeMillis() / 1000;

        try {
            //todo 方法前需要执行的代码 操作 比如 设置缓存 开启事务。。。
            res = joinPoint.proceed(); //获取到了切入点
            //todo 方法后需要执行的代码 操作 比如 设置缓存 开启事务。。。
            return res;
        } finally {
            try {
                //方法执行完成后增加日志
                saveLog(joinPoint, res, time);
            } catch (Exception e) {
                System.out.println("LogAspect 操作失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * 新增日志信息
     * @param joinPoint
     * @param res
     * @param time
     */
    public void saveLog(JoinPoint joinPoint, Object res, long time) {
        long runTime = (System.currentTimeMillis() / 1000) - time;
        Log sysLog = new Log();
        //创建时间
        sysLog.setCreateTime(System.currentTimeMillis());
        //创建人  todo 通过session获取操作人之类的
        sysLog.setUserName("myf");
        //方法耗时
        sysLog.setRunTime(runTime);
        //备注
        sysLog.setRemarks("备注新增正常，方法返回值为" + res);
        // todo 通过HttpServletRequest 获取url端口  。。。。

        //从切面点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法 注解

        LogAnn log = signature.getMethod().getAnnotation(LogAnn.class);
        if (log != null) {
            sysLog.setButtonName(log.buttonName());
            sysLog.setModuleName(log.moduleName());
        }
        String s = logService.saveLog(sysLog);
        System.out.println(s);
    }

    /**
     * 方法前执行
     * @param joinPoint
     */
    @Before("myLogPoincut()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("进入方法前执行.....");

    }

    /**
     * 处理完请求，返回内容
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "myLogPoincut()")
    public void doAfterReturning(Object ret) {
        System.out.println("方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     * @param jp
     */
    @AfterThrowing("myLogPoincut()")
    public void throwss(JoinPoint jp) {
        System.out.println("方法异常时执行.....");
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("myLogPoincut()")
    public void after(JoinPoint jp) {
        System.out.println("方法最后执行.....");
    }

}
