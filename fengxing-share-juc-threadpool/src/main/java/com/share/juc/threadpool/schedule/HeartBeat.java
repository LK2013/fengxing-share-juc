package com.share.juc.threadpool.schedule;

import lombok.Data;

/**
 * 心跳发送
 * @ClassName: HeartBeat
 * @package com.share.juc.threadpool.schedule
 * @author: lk
 * @date: 2020/10/13 14:20
*/
@Data
public class HeartBeat {
    private String ip;
    private int port;
    private String appName;
    private String instanceId;
}
