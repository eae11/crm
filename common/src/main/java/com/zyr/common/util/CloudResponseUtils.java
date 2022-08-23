package com.zyr.common.util;

import com.alibaba.fastjson.JSON;
import com.zyr.common.vo.CloudResult;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * 封装的输出工具类，同学们可以直接使用，和业务无关
 */
@Slf4j
public class CloudResponseUtils {

    public static void out(ServletResponse response, CloudResult cloudResult) {
        PrintWriter out = null;
        try {
            // Array老师提醒，这里可以设置不同的字符编码，根据同学的自己的业务来
            response.setCharacterEncoding("UTF-8");
            // Array老师提醒，这里可以设置自己的输出格式也可以是text/html,根据业务而定
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(cloudResult));
        } catch (Exception e) {

              e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

}
