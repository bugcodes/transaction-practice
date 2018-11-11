package bugcodes.util;

import java.sql.Timestamp;

/**
 * @author bugcoder
 * @date 18/11/8
 */
public class DateUtil {

    /**
     * 获取当前时间戳
     * @return
     */
    public static Timestamp getSysDate(){
        return new Timestamp(System.currentTimeMillis());
    }
}
